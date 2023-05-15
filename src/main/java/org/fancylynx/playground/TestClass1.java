package org.fancylynx.playground;

//import lombok.Data;


public record TestClass1(String testString, int testInt1, int testInt2) {
}

//public @Data class TestClass2 {
//    private final String testString;
//    private final int testInt1;
//    private final int testInt2;
//
//    public TestClass1(String testString, int testInt1, int testInt2) {
//        this.testString = testString;
//        this.testInt1 = testInt1;
//        this.testInt2 = testInt2;
//    }
//}


//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        TestClass1 that = (TestClass1) o;
//        return testInt1 == that.testInt1 && getTestInt2 == that.getTestInt2 && Objects.equals(testString, that.testString);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(testString, testInt1, getTestInt2);
//    }
//}
