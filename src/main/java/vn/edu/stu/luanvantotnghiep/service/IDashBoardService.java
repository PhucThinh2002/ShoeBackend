package vn.edu.stu.luanvantotnghiep.service;

import vn.edu.stu.luanvantotnghiep.model.DashBoard;

public interface IDashBoardService {
    public DashBoard create(DashBoard dashBoard);
    public DashBoard findByDateBefore();
    public DashBoard getValueInDateNow();
    public DashBoard scheduleEveryDay();
}
