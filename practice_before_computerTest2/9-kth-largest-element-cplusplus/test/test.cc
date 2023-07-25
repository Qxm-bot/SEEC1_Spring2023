#include <gtest/gtest.h>
#include "kth-largest-element.h"

TEST(FACTORIALTEST, test1) {
  int nums[]= {1, 2, 3, 4, 5, 6};
  int n =6;
  int k =2;
  int expect = 5;
  EXPECT_EQ(expect, findKthLargest(nums,n,k));
}

TEST(FACTORIALTEST, test2) {
  int nums []= { 3, 2, 1, 5, 6, 4 };
  int n = 6;
  int k = 3;
  int expect = 4;
  EXPECT_EQ(expect, findKthLargest(nums,n,k));
}

TEST(FACTORIALTEST, test3) {
  int nums []= { 3, 2, 1, 5, 6, 4 };
  int n = 6;
  int k = 6;
  int expect = 1;
  EXPECT_EQ(expect, findKthLargest(nums,n,k));
}

TEST(FACTORIALTEST, test4) {
  int nums[] = {1, 1, 2, 2, 3, 3};
  int n = 6;
  int k = 2;
  int expect = 3;
  EXPECT_EQ(expect, findKthLargest(nums,n,k));
}

TEST(FACTORIALTEST, test5) {
  int nums[] = {6, 5, 4, 3, 2, 1};
  int n = 6;
  int k = 1;
  int expect = 6;
  EXPECT_EQ(expect, findKthLargest(nums,n,k));
}