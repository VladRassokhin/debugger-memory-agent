package com.intellij.memory.agent.proxy;

public class IdeaNativeAgentProxy {
  private IdeaNativeAgentProxy() {
  }

  public static native boolean canFindGcRoots();

  public static native boolean canEstimateObjectSize();

  public static native boolean canGetRetainedSizeByClasses();

  public static native boolean canGetShallowSizeByClasses();

  public static native boolean canEstimateObjectsSizes();

  public static native boolean canFindPathsToClosestGcRoots();

  public static native long[] getShallowSizeByClasses(Class<?>[] classes);

  public static native long[] getRetainedSizeByClasses(Class<?>[] classes);

  public static native Object gcRoots(Object object, int limit);

  public static native Object findPathsToClosestGcRoots(Object object, int number);

  public static native long size(Object object);

  public static native long[] estimateRetainedSize(Object[] objects);

  public static boolean isLoaded() {
    try {
      return isLoadedImpl();
    } catch (Throwable t) {
      return false;
    }
  }

  private static native boolean isLoadedImpl();
}
