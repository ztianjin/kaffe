package java.lang;


/*
 * Java core library component.
 *
 * Copyright (c) 1997, 1998
 *      Transvirtual Technologies, Inc.  All rights reserved.
 *
 * See the file "license.terms" for information on usage and redistribution
 * of this file.
 */
final public class Integer
  extends Number
{
	private int value;
	final public static Class TYPE = Class.getPrimitiveClass("int");
	final public static int MIN_VALUE = 0x80000000;
	final public static int MAX_VALUE = 0x7fffffff;

public Integer(String s) throws NumberFormatException
{
	this(parseInt(s));
}

public Integer(int value)
	{
	this.value=value;
}

public byte byteValue()
	{
	return ((byte)value);
}

public static Integer decode(String nm) throws NumberFormatException
{
	if (nm.startsWith("0x")) {
		return (Integer.valueOf(nm.substring(2), 16));
	}
	else if (nm.startsWith("#")) {
		return (Integer.valueOf(nm.substring(1), 16));
	}
	else if (nm.startsWith("0")) {
		return (Integer.valueOf(nm.substring(1), 8));
	}
	else {
		return (Integer.valueOf(nm.substring(1), 10));
	}
}

public double doubleValue() {
	return (double )value;
}

public boolean equals(Object obj) {
	if ((obj!=null) && (obj instanceof Integer)) {
		return (this.intValue()==((Integer )obj).intValue());
	}
	else {
		return false;
	}
}

public float floatValue() {
	return (float )value;
}

public static Integer getInteger(String nm) {
	return getInteger(nm, (Integer) null);
}

public static Integer getInteger(String nm, Integer val) {
	String arg;

	if (val==null) arg=null; else arg=val.toString();

	String prop=System.getProperty(nm, arg);

	try {
		if (prop==null) return val;
		else if (prop.startsWith("0x")) return Integer.valueOf(prop.substring(2), 16);
		else if (prop.startsWith("#")) return Integer.valueOf(prop.substring(1), 16);
		else if (prop.startsWith("0")) return Integer.valueOf(prop.substring(1), 8);
		else return new Integer(prop);
	}
	catch (NumberFormatException e) {
		return val;
	}
}

public static Integer getInteger(String nm, int val) {
	return getInteger(nm, new Integer(val));
}

public int hashCode() {
	return this.intValue();
}

public int intValue()
	{
	return value;
}

public long longValue() {
	return (long )value;
}

public static int parseInt(String s) throws NumberFormatException
{
	return (parseInt(s, 10));
}

public static int parseInt(String s, int radix) throws NumberFormatException
{
	if (s.length()<=0) throw new NumberFormatException();

	/* Check for negativity */
	if (s.charAt(0)=='-')
		{
		return parseInt(s.substring(1), radix)*-1;
	}
	else
		{
		int result=0;
		int position;

		for (position=0; position<s.length(); position++)
			{
			int digit=Character.digit(s.charAt(position), radix);
			if (digit==-1) throw new NumberFormatException();

			result=(result*radix)+digit;
		}

		return result;
	}
}

public short shortValue()
	{
	return ((short)value);
}

public static String toBinaryString(int i) {
	return toString(i, 2);
}

public static String toHexString(int i) {
	return toString(i, 16);
}

public static String toOctalString(int i) {
	return toString(i, 8);
}

public String toString()
	{
	return toString(this.intValue());		
}

public static String toString(int i)
	{
	return toString(i, 10);
}

public static String toString(int i, int radix)
	{
	if (i == 0) {
		return ("0");
	}

	if (radix < Character.MIN_RADIX || radix > Character.MAX_RADIX) {
		radix = 10;
	}

	StringBuffer buf = new StringBuffer();
	int sign = 1;
	if (i < 0) {
		sign = -1;
	}
	while (i != 0) {
		char digit = Character.forDigit(Math.abs(i % radix), radix);
		i = i / radix;
		buf.append(digit);
	}
	if (sign == -1) {
		buf.append('-');
	}
	buf.reverse();
	return (buf.toString());
}

public static Integer valueOf(String s) throws NumberFormatException
{
	return valueOf(s, 10);
}

public static Integer valueOf(String s, int radix) throws NumberFormatException
{
	return new Integer(parseInt(s, radix));
}
}
