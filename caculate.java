package pairwork;

import java.util.Random;

public class caculate {
    public String generate(int range, int num, boolean b) throws Exception {
        char[] ope = new char[]{'+', '-', '*', '/'};//四则运算符号
        Random ran = new Random();
        int cacu = ran.nextInt(3);//运算式子中运算符的个数
        int x = ran.nextInt(range);//第一个数字
        int yon = ran.nextInt(3);//0:无括号 1：1个 2：两个
        StringBuffer stb = new StringBuffer();
        if (!b || yon == 0) {                       //不需要括号
            stb.append(x);
            for (int i = 0; i <= cacu; i++) {
                int chars = ran.nextInt(4);
                int y = ran.nextInt(range);
                stb.append(" ");
                stb.append(ope[chars]);
                stb.append(" ");
                stb.append(y);
            }
        } else { //需要一个或者两个括号
            if (cacu == 0) {
                stb.append(x);
                int chars = ran.nextInt(4);
                int y = ran.nextInt(range);
                stb.append(" ");
                stb.append(ope[chars]);
                stb.append(" ");
                stb.append(y);
            } else if (cacu == 1) {
                int position = ran.nextInt(2);
                if (position == 0) {
                    int chars = ran.nextInt(4);
                    int y = ran.nextInt(range);
                    int chars1 = ran.nextInt(4);
                    int y1 = ran.nextInt(range);
                    stb.append("(");
                    stb.append(" ");
                    stb.append(x);
                    stb.append(" ");
                    stb.append(ope[chars]);
                    stb.append(" ");
                    stb.append(y);
                    stb.append(" ");
                    stb.append(")");
                    stb.append(" ");
                    stb.append(ope[chars1]);
                    stb.append(" ");
                    stb.append(y1);
                }
                if (position == 1) {
                    int chars = ran.nextInt(4);
                    int y = ran.nextInt(range);
                    int chars1 = ran.nextInt(4);
                    int y1 = ran.nextInt(range);
                    stb.append(x);
                    stb.append(" ");
                    stb.append(ope[chars]);
                    stb.append(" ");
                    stb.append("(");
                    stb.append(" ");
                    stb.append(y);
                    stb.append(" ");
                    stb.append(ope[chars1]);
                    stb.append(" ");
                    stb.append(y1);
                    stb.append(" ");
                    stb.append(")");
                }
            } else {
                if (yon == 1) {
                    Boolean s1 = true;
                    Boolean s2 = true;
                    int firsta = 99;
                    int a = ran.nextInt(2);
                    if (a == 1) {
                        stb.append("(");
                        stb.append(" ");
                        s1 = false;
                        firsta = -1;
                    }
                    stb.append(x);
                    for (int i = 0; i <= cacu; i++) {
                        int chars = ran.nextInt(4);
                        int y = ran.nextInt(range);
                        stb.append(" ");
                        stb.append(ope[chars]);
                        stb.append(" ");
                        if (s1 == true) {
                            if (i == 1) {
                                stb.append("(");
                                stb.append(" ");
                                s1 = false;
                                firsta = i;
                            } else if (i == 0) {
                                int a1 = ran.nextInt(2);
                                if (a1 == 1) {
                                    stb.append("(");
                                    stb.append(" ");
                                    s1 = false;
                                    firsta = i;
                                }
                            }
                        }
                        stb.append(y);
                        if (s1 == false && s2 == true && i > firsta) {
                            if (i == 2 && firsta != -1) {
                                stb.append(" ");
                                stb.append(")");
                                s2 = false;
                            }
                            else if(i == 1 && firsta == -1){
                                stb.append(" ");
                                stb.append(")");
                                s2 = false;
                            }
                            else {
                                int a1 = ran.nextInt(2);
                                if (a1 == 1) {
                                    stb.append(" ");
                                    stb.append(")");
                                    s2 = false;
                                }
                            }
                        }
                    }
                }
                if (yon == 2) {
                    int a = ran.nextInt(5);
                    if (a == 0) {
                        stb.append("( ( ");
                        stb.append(x);
                        for (int i = 0; i <= cacu; i++) {
                            int chars = ran.nextInt(4);
                            int y = ran.nextInt(range);
                            stb.append(" ");
                            stb.append(ope[chars]);
                            stb.append(" ");
                            stb.append(y);
                            if (i == 0) {
                                stb.append(" )");
                            }
                            if (i == 1) {
                                stb.append(" )");
                            }
                        }
                    } else if (a == 2) {
                        stb.append("( ");
                        stb.append(x);
                        for (int i = 0; i <= cacu; i++) {
                            int chars = ran.nextInt(4);
                            int y = ran.nextInt(range);
                            stb.append(" ");
                            stb.append(ope[chars]);
                            stb.append(" ");
                            if (i == 0) {
                                stb.append("( ");
                            }
                            stb.append(y);
                            if (i == 1) {
                                stb.append(" ) )");
                            }
                        }
                    } else if (a == 1) {
                        stb.append(x);
                        for (int i = 0; i <= cacu; i++) {
                            int chars = ran.nextInt(4);
                            int y = ran.nextInt(range);
                            stb.append(" ");
                            stb.append(ope[chars]);
                            stb.append(" ");
                            if (i == 0) {
                                stb.append("( ( ");
                            }
                            stb.append(y);
                            if (i == 1) {
                                stb.append(" )");
                            }
                            if (i == 2) {
                                stb.append(" )");
                            }
                        }
                    } else if (a == 3) {
                        stb.append(x);
                        for (int i = 0; i <= cacu; i++) {
                            int chars = ran.nextInt(4);
                            int y = ran.nextInt(range);
                            stb.append(" ");
                            stb.append(ope[chars]);
                            stb.append(" ");
                            if (i == 0) {
                                stb.append("( ( ");
                            }
                            stb.append(y);
                            if (i == 1) {
                                stb.append(" )");
                            }
                            if (i == 2) {
                                stb.append(" )");
                            }
                        }
                    } else {
                        stb.append("( ");
                        stb.append(x);
                        for (int i = 0; i <= cacu; i++) {
                            int chars = ran.nextInt(4);
                            int y = ran.nextInt(range);
                            stb.append(" ");
                            stb.append(ope[chars]);
                            stb.append(" ");
                            if (i == 1) {
                                stb.append("( ");
                            }
                            stb.append(y);
                            if (i == 0) {
                                stb.append(" )");
                            }
                            if (i == 2) {
                                stb.append(" )");
                            }
                        }
                    }
                }
            }
        }
            stb.append(" ");
            stb.append('=');
            return stb.toString();
    }
}