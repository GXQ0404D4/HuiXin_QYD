package com.ktcn.utils;

public class PageReade {
	/*
	 * 获取分页查询参数 pageSize 当前页 Count 总条数 messNum 每页显示数量
	 */
	public static int getPageSize(int pageSize, int Count, int messNum) {
		if (Count < 1) {
			Count = 1;
		}
		// 定义一个临时变量
		int x = 0;
		// 对传入页数进行处理避免出现负数
		if (pageSize <= 0) {
			pageSize = 1;
		}
		// 根据数据库信息总条数对最大页数进行处理, 避免当前页查出最大页数
		if (Count % messNum == 0) {
			x = Count / messNum;
		} else {
			x = Count / messNum + 1;
		}
		if (pageSize > x) {
			pageSize = x;
		}
		// 返回查询起始条数
		return (pageSize - 1) * messNum;
	}

	/*
	 * 获取当前页
	 */
	public static int getPageNum(int pageSize, int Count, int messNum) {
		if (Count < 1) {
			Count = 1;
		}
		// 定义一个临时变量
		int x = 0;
		// 对传入页数进行处理避免出现负数
		if (pageSize <= 0) {
			pageSize = 1;
		}
		// 根据数据库信息总条数对最大页数进行处理, 避免当前页查出最大页数
		if (Count % messNum == 0) {
			x = Count / messNum;
		} else {
			x = Count / messNum + 1;
		}
		if (pageSize > x) {
			pageSize = x;
		}
		return pageSize;
	}

	/*
	 * 获取总页数
	 */
	public static int getCountPage(int Count, int messNum) {
		// 定义一个临时变量
		int x = 0;
		// 根据数据库信息总条数对最大页数进行处理, 避免当前页查出最大页数
		if (Count % messNum == 0) {
			x = Count / messNum;
		} else {
			x = Count / messNum + 1;
		}
		// 返回数据总页数
		return x;
	}

}
