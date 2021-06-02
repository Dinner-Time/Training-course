package pkg.inheritence;

public class A {
	char a = 'a';
}

class B extends A{
	char b = 'b';
}

class C extends A{
	char c = 'c';
}

interface X extends Z{
	
}

interface Y{
	
}

interface Z{
	
}
class D extends B implements X, Y{
	char d = 'd';
}

class E extends C{
	char e = 'e';
}

