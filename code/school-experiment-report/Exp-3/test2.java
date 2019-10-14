import java.text.DecimalFormat;

public class test2 {
    public static void main(String[] args) {
        System.out.println("-- Test2 : Line2D design --");
        // create l1
        Point2D p1 = new Point2D(2, 3);
        Point2D p2 = new Point2D(4, 7);
        Line2D l1 = new Line2D(p1, p2);
        System.out.println("\nl1 's general expression : " + l1.showGeneral());
        System.out.println("l1 's slope-intercept expression : " + l1.showSlopeIntercept());
        // create l2
        Point2D p3 = new Point2D(4, 7);
        double k = Double.POSITIVE_INFINITY;
        Line2D l2 = new Line2D(p3, k);
        System.out.println("\nl2 's general expression : " + l2.showGeneral());
        System.out.println("l2 's slope-intercept expression : " + l2.showSlopeIntercept());
        // create l3
        Line2D l3 = new Line2D(0.5, -1);
        System.out.println("\nl3 's general expression : " + l3.showGeneral());
        System.out.println("l3 's slope-intercept expression : " + l3.showSlopeIntercept());
        // create l4
        Line2D l4 = new Line2D(0, 4);
        System.out.println("\nl4 's general expression : " + l4.showGeneral());
        System.out.println("l4 's slope-intercept expression : " + l4.showSlopeIntercept());

        // is p1 p2 equal?
        System.out.println("\nis p1 p2 equal? " + p1.equals(p2));
        // is p2 p3 equal?
        System.out.println("is p2 p3 equal? " + p2.equals(p3));

        // is l1 l2 equal?
        System.out.println("\nis l1 l2 equal? " + l1.equals(l2));
        // is l1 l2 parallel?
        System.out.println("is l1 l2 parallel? " + l1.isParallel(l2));

        // is l1 l3 equal?
        System.out.println("\nis l1 l3 equal? " + l1.equals(l3));
        // is l1 l3 parallel?
        System.out.println("is l1 l3 parallel? " + l1.isParallel(l3));

        // is l2 l4 equal?
        System.out.println("\nis l2 l4 equal? " + l2.equals(l4));
        // is l2 l4 parallel?
        System.out.println("is l2 l4 parallel? " + l2.isParallel(l4));
    }
}

class Point2D {
    double x;
    double y;

    public Point2D() {
        x = y = 0;
    }

    public Point2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public boolean equals(Point2D point) {
        if (point.x == x && point.y == y) {
            return true;
        } else {
            return false;
        }
    }
}

class Line2D {
    // Ax+By+C=0 (A||B==1)
    double A;
    double B;
    double C;

    public Line2D(Point2D point, double k) {
        if (k != Double.POSITIVE_INFINITY && k != Double.NEGATIVE_INFINITY) {
            A = k;
            B = -1;
            C = point.y - k * point.x;
        } else {
            A = 1;
            B = 0;
            C = -point.x;
        }
    }

    public Line2D(Point2D point1, Point2D point2) {
        A = point2.y - point1.y;
        B = point1.x - point2.x;
        C = (point2.x - point1.x) * point1.y + (point1.y - point2.y) * point1.x;
    }

    public Line2D(double x, double y) {
        A = y;
        B = x;
        C = -(x * y);
    }

    // A==0&&B==0 -> false
    public boolean lineDetect() {
        if (A == 0 && B == 0) {
            return false;
        } else {
            return true;
        }
    }

    // Ax+By+C=0
    public String showGeneral() {
        String strA = "";
        String strB = "";
        String strC = "";
        if (!lineDetect()) {
            System.out.println("Error: not satisfy a line.\n(program is ready to exit!)");
            System.exit(0);
        }
        if (A < 0) {
            strA = Digit.format(-A, true, true) + "x";
            if (B == 0) {
                strB = "";
                if (C == 0) {
                    strA = "x";
                    strC = "";
                } else {
                    strC = Digit.format(-C, false, false);
                }
            } else {
                strB = Digit.format(-B, false, true) + "y";
                if (C == 0) {
                    strC = "";
                } else {
                    strC = Digit.format(-C, false, false);
                }
            }
        } else if (A == 0) {
            strA = "";
            if (B < 0) {
                strB = Digit.format(-B, true, true) + "y";
                if (C == 0) {
                    strB = "y";
                    strC = "";
                } else {
                    strC = Digit.format(-C, false, false);
                }
            } else if (B > 0) {
                strB = Digit.format(B, true, true) + "y";
                if (C == 0) {
                    strB = "y";
                    strC = "";
                } else {
                    strC = Digit.format(C, false, false);
                }
            }
        } else if (A > 0) {
            strA = Digit.format(A, true, true) + "x";
            if (B == 0) {
                strB = "";
                if (C == 0) {
                    strA = "x";
                    strC = "";
                } else {
                    strC = Digit.format(C, false, false);
                }
            } else {
                strB = Digit.format(B, false, true) + "y";
                if (C == 0) {
                    strC = "";
                } else {
                    strC = Digit.format(C, false, false);
                }
            }
        }
        return strA + strB + strC + "=0";
    }

    // y=kx+b
    public String showSlopeIntercept() {
        if (!lineDetect()) {
            System.out.println("Error: not satisfy a line.\n(program is ready to exit!)");
            System.exit(0);
        }
        if (B == 0) {
            System.out.println("(Error: can't use Slope-Intercept to express)");
            return "";
        } else {
            double k;
            double b;
            String strk = "";
            String strb = "";
            k = -A / B;
            b = -C / B;
            if (k == 0) {
                strk = "";
                if (b == 0) {
                    strb = "0";
                } else {
                    strb = String.valueOf(b);
                }
            } else {
                strk = Digit.format(k, true, true) + "x";
                if (b == 0) {
                    strb = "";
                } else {
                    strb = Digit.format(b, false, false);
                }
            }

            return "y=" + strk + strb;
        }
    }

    public boolean equals(Line2D line) {
        if (!lineDetect()) {
            System.out.println("Error: not satisfy a line.\n(program is ready to exit!)");
            System.exit(0);
        }
        double k1 = line.A / A;
        double k2 = line.B / B;
        double k3 = line.C / C;
        if (k1 == k2 && k1 == k3) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isParallel(Line2D line) {
        if (!lineDetect()) {
            System.out.println("Error: not satisfy a line.\n(program is ready to exit!)");
            System.exit(0);
        }
        if (equals(line)) {
            return false;
        } else {
            if (line.A == 0 && A == 0) {
                if (line.B * C == line.C * B) {
                    return false;
                } else {
                    return true;
                }
            } else if (line.B == 0 && B == 0) {
                if (line.A * C == line.C * A) {
                    return false;
                } else {
                    return true;
                }
            } else {
                if (line.A * B == line.B * A && line.B * C != line.C * B) {
                    return true;
                } else {
                    return false;
                }
            }
        }
    }
}

class Digit {
    public static String format(double digit, boolean isA, boolean hide1) {
        DecimalFormat df = new DecimalFormat("#.####");
        String str = String.valueOf(df.format(digit));
        if (str.charAt(0) == '-') {
            if (hide1) {
                if (str.compareTo("-1") == 0) {
                    return "-";
                } else {
                    return str;
                }
            } else {
                return str;
            }
        } else {
            if (hide1) {
                if (str.compareTo("1") == 0) {
                    if (isA) {
                        return "";
                    } else {
                        return "+";
                    }
                } else {
                    if (isA) {
                        return str;
                    } else {
                        return "+" + str;
                    }
                }
            } else {
                if (isA) {
                    return str;
                } else {
                    return "+" + str;
                }
            }
        }
    }
}