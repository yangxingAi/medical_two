package com.cqupt.software_1.Util;

import java.sql.*;
import java.util.*;

public class CDividedQuickRduct {
    private int[][] InfTable;
    private int m_AttributeNum;
    private int[] L;
    private int Average;
    public Set<Integer> satisfiedSamples;  // 存储满足条件的样本标签
    private int[] featureOrder;

    public void twoDimensionQuickSort(int[][] table, int numAttributes,int numOfSamples,float sicknessRate) {
        InfTable = table;
        m_AttributeNum = numAttributes;
        int n = table.length;
        L = new int[n];
        for (int i = 0; i < n; i++) {
            L[i] = i;
        }

        featureOrder = new int[m_AttributeNum];
        randFeatureOrder();

        twoDimensionQuickSortHelper(0, 0, n - 1,numOfSamples,sicknessRate);
    }

    private void twoDimensionQuickSortHelper(int r, int low, int high,int numOfSamples,float sicknessRate) {
        if (r >= m_AttributeNum) return;
        if (!needBeProcess(r, low, high, m_AttributeNum,numOfSamples,sicknessRate)) return;
        if (low >= high) return;

        boolean canBePartition = false;
        int temp = InfTable[L[low]][r];
        Average = 0;
        int totalSum = 0;
        for (int j = low + 1; j <= high; j++) {
            if (temp != InfTable[L[j]][r]) {
                canBePartition = true;
                break;
            }
        }

        if (canBePartition) {
            int mid = partition(r, low, high);
            twoDimensionQuickSortHelper(r, low, mid,numOfSamples,sicknessRate);
            mid = mid + 1;
            twoDimensionQuickSortHelper(r, mid, high,numOfSamples,sicknessRate);
        } else {
            r = r + 1;
            twoDimensionQuickSortHelper(r, low, high,numOfSamples,sicknessRate);
        }
    }

    // 中止函数
    private boolean needBeProcess(int r, int low, int high, int m_AttributeNum,int numOfSamples,float sicknessRate) {
        // 样本规模 numOfSamples
        // 发病率 sicknessRate
        satisfiedSamples = new HashSet<>();

        if (high - low + 1 < numOfSamples) return false;

        int totalSickness = 0;
        for (int j = low; j <= high; j++) {
//            if (InfTable[featureOrder[j]] != null && InfTable[featureOrder[j]].length >= m_AttributeNum && InfTable[L[featureOrder[j]]][m_AttributeNum] == 1) {
//                totalSickness++;
//            }
            if (InfTable[L[j]][m_AttributeNum] == 1){
                totalSickness++;
            }
        }

        float tempRate = (float) totalSickness / (high - low + 1);
        if (tempRate >= sicknessRate) {
            for (int j = low; j <= high; j++) {
//                if (InfTable[featureOrder[j]] != null && InfTable[featureOrder[j]].length >= m_AttributeNum && InfTable[L[featureOrder[j]]][m_AttributeNum ] == 1) {
//                    satisfiedSamples.add(L[j]);
//                }
                satisfiedSamples.add(L[j]);
            }
            return false;
        } else {
            return true;
        }
    }


    private int partition(int r, int low, int high) {
        int i = low, j = high;
        int temp;
        int count = 0;
        for (int k = low; k <= high; k++) {
            count += InfTable[L[k]][r];
        }
        Average = count / (high - low + 1);
        while (i < j) {
            while ((InfTable[L[j]][r] > Average) && (i < j)) {
                j--;
            }
            temp = L[i];
            L[i] = L[j];
            L[j] = temp;
            while ((InfTable[L[i]][r] <= Average) && (i < j)) {
                i++;
            }
            temp = L[i];
            L[i] = L[j];
            L[j] = temp;
        }
        if (InfTable[L[i]][r] > Average)
            return i - 1;
        else
            return i;
    }

    public void printTable(int[][] table) {
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[i].length; j++) {
                System.out.print(table[i][j] + " ");
            }
            System.out.println();
        }
    }

    public int[] getSortedIndices() {
        return L;
    }

    // 随机给所有特征(m个特征)赋予不同的序号值（1-m）
    private void randFeatureOrder() {
        int m = m_AttributeNum;
        List<Integer> orderList = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            orderList.add(i);
        }
        Collections.shuffle(orderList);
        for (int i = 0; i < m; i++) {
            featureOrder[i] = orderList.get(i);
        }
    }

    public void quickIterative(int numOfSamples,float sicknessRate) {
        satisfiedSamples = new HashSet<>();

        for (int k = 0; k < 1000; k++) {
            randFeatureOrder();
            int r = 0;
            int low = 0;
            int high = L.length - 1;
            twoDimensionQuickSortHelper(r, low, high,numOfSamples,sicknessRate);
        }
    }

    public Set<Integer> getSatisfiedSamples() {
        return satisfiedSamples;
    }


    public Map<String,Object> printSetInfo(Set<Integer> set) {
        int totalSamples = set.size();
        int positiveSamples = 0;

        for (int sample : set) {
            if (InfTable[sample][m_AttributeNum] == 1) {
                positiveSamples++;
            }
        }

        float diseaseRate = (float) positiveSamples / totalSamples;



        Map<String,Object> map = new HashMap<>();
        map.put("划分出的人群总数",totalSamples);
        map.put("划分出的人群患病总数",positiveSamples);
        map.put("划分出的人群患病率",diseaseRate);
        return map;
    }

}
