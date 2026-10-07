package com.beigu.yunbeiuc.screen;

import net.minecraft.client.Minecraft;

/**
 * 布局辅助工具 — 屏幕尺寸与矩形命中检测。
 *
 * <p>仅保留与具体界面无关的通用几何工具，供各界面复用。
 */
public final class LayoutHelper {
    private LayoutHelper() {
    }

    /** 判断鼠标坐标是否落在矩形内（闭区间）。 */
    public static boolean isMouseInRect(double mx, double my, int x, int y, int w, int h) {
        return mx >= x && mx <= x + w && my >= y && my <= y + h;
    }

    /** 当前 GUI 缩放后的屏幕宽度。 */
    public static int getScreenWidth() {
        return Minecraft.getInstance().getWindow().getGuiScaledWidth();
    }

    /** 当前 GUI 缩放后的屏幕高度。 */
    public static int getScreenHeight() {
        return Minecraft.getInstance().getWindow().getGuiScaledHeight();
    }
}
