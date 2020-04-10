package size.classes.retained;

import common.TestBase;
import common.TestTreeNode;

public class OneClassInSameSubtree2 extends TestBase {
    public static void main(String[] args) {
     /*
                        1
                      /   \
                     2     1
                   /   \
                  1     1
                 / \
                1   2
                   / \
                  1   1
        */
        TestTreeNode root = TestTreeNode.createTreeFromString("1 2 1 1 0 0 2 1 0 0 1 0 0 1 0 0 1 0 0");
        printRetainedSizeByClasses(TestTreeNode.Impl2.class);
    }
}
