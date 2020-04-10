package common;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

public abstract class TestTreeNode {
    private TestTreeNode left;
    private TestTreeNode right;

    @FunctionalInterface
    private interface ImplCreator {
        TestTreeNode create();
    }

    private static final Map<String, ImplCreator> TOKEN_TO_IMPL = new HashMap<>();
    static {
        TOKEN_TO_IMPL.put("0", () -> null);
        TOKEN_TO_IMPL.put("1", Impl1::new);
        TOKEN_TO_IMPL.put("2", Impl2::new);
        TOKEN_TO_IMPL.put("3", Impl3::new);
    };

    private TestTreeNode() {
    }

    private static TestTreeNode createNode(Iterator<String> it) {
        TestTreeNode resultNode = TOKEN_TO_IMPL.get(it.next()).create();

        if (resultNode == null) {
            return null;
        }

        resultNode.left = createNode(it);
        resultNode.right = createNode(it);

        return resultNode;
    }

    public static TestTreeNode createTreeFromString(String str) {
        ArrayList<String> tokens = new ArrayList<>(Arrays.asList(str.split("\\s+")));
        return createNode(tokens.iterator());
    }

    public static class Impl1 extends TestTreeNode {
        private Impl1 () {
            super();
        }
    }

    public static class Impl2 extends TestTreeNode {
        private Impl2 () {
            super();
        }
    }

    public static class Impl3 extends TestTreeNode {
        private Impl3 () {
            super();
        }
    }
}
