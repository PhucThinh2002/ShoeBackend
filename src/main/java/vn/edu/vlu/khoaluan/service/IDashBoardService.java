package vn.edu.vlu.khoaluan.service;

import vn.edu.vlu.khoaluan.model.DashBoard;

public interface IDashBoardService {
    public DashBoard create(DashBoard dashBoard);
    public DashBoard findByDateBefore();
    public DashBoard getValueInDateNow();
    public DashBoard scheduleEveryDay();
}
