import java.util.Random;

public class test1{
    public static void main(String[] args) {
        System.out.println("-- Test1 : Rational Comparable --");

        Random random = new Random();
        Rational [] rationals = new Rational[100];
        InverseComparator [] invRationals = new InverseComparator[100];
        for(int i = 0; i < rationals.length; ) {
            int randomN = random.nextInt(200) - 100;
            int randomD;
            do {
                randomD = random.nextInt(200) - 100;
            } while(Math.abs(randomD) <= Math.abs(randomN));
            // 分子分母不同时等于0
            if (randomN != 0 || randomD != 0) {
                invRationals[i] = new InverseComparator(randomD, randomN);
                rationals[i++] = new Rational(randomN, randomD);
            } else {
                System.out.println("Ration Exception: 0/0");
            }
        }

        for (int i = 0; i < rationals.length-1; i++) {
            for (int j = 0; j < rationals.length-1-i; j++) {
                if (rationals[j].compareTo(rationals[j+1]) == 1) {
                    Rational temp = rationals[j];
                    rationals[j] = rationals[j+1];
                    rationals[j+1] = temp;                  
                }
            }
        }
        for (Rational rational : rationals) {
            System.out.println(rational);
        }

        for (int i = 0; i < invRationals.length-1; i++) {
            for (int j = 0; j < invRationals.length-1-i; j++) {
                if (invRationals[j].compareTo(invRationals[j+1]) == 1) {
                    InverseComparator temp = invRationals[j];
                    invRationals[j] = invRationals[j+1];
                    invRationals[j+1] = temp;                  
                }
            }
        }
        for (InverseComparator invRaitonal : invRationals) {
            System.out.println(invRaitonal);
        }
    }
}


class Rational implements Comparable<Rational> {

    private int numerator;
    private int denominator;

    public Rational(int numerator, int denominator) {
        
        this.numerator = numerator;
        this.denominator = denominator;
        
    }

	@Override
	public int compareTo(Rational r) {
        /*
         * return 1, A > B
         * return 0, A = B
         * return -1,A < B
         */
        if (this.numerator*this.denominator > 0 && r.numerator*r.denominator < 0) {
            return 1;
        }
        if (this.numerator*this.denominator < 0 && r.numerator*r.denominator > 0) {
            return -1;
        }
        // both positive or both negative
        if (this.numerator != 0 && this.denominator != 0 && r.numerator != 0 && r.denominator != 0) {
            if (Math.abs(this.numerator*r.denominator) > Math.abs(r.numerator*this.denominator)) {
                if (this.numerator*this.denominator > 0) {
                    return 1;
                } else {
                    return -1;
                }
            } else if (Math.abs(this.numerator*r.denominator) < Math.abs(r.numerator*this.denominator)) {
                if (this.numerator*this.denominator > 0) {
                    return -1;
                } else {
                    return 1;
                }
            } else {
                return 0;
            }
        }
        // some number equals to zero
        else {
            if (this.numerator != 0 && this.denominator != 0) {
                boolean isPos = true;
                if (this.numerator*this.denominator > 0) {
                    isPos = true;
                } else {
                    isPos = false;
                }
                if (r.numerator == 0) {
                    if (isPos) {
                        return 1;
                    } else {
                        return -1;
                    }
                } else if (r.denominator == 0) {
                    if (r.numerator > 0) {
                        return -1;
                    } else if (r.numerator < 0) {
                        return 1;
                    }
                }

            } else if (r.numerator != 0 && r.denominator != 0) {
                boolean isPos = true;
                if (r.numerator*r.denominator > 0) {
                    isPos = true;
                } else {
                    isPos = false;
                }
                if (this.numerator == 0) {
                    if (isPos) {
                        return 1;
                    } else {
                        return -1;
                    }
                } else if (this.denominator == 0) {
                    if (this.numerator > 0) {
                        return -1;
                    } else if (this.numerator < 0) {
                        return 1;
                    }
                }
            } else if (this.numerator == 0 && r.numerator == 0) {
                return 0;
            } else if (this.numerator == 0 && r.denominator == 0) {
                if (r.numerator > 0) {
                    return -1;
                } else {
                    return 1;
                }
            } else if (this.denominator == 0 && r.numerator == 0) {
                if (this.numerator > 0) {
                    return 1;
                } else {
                    return -1;
                }
            } else if (this.denominator == 0 && r.denominator == 0) {
                if (this.numerator*r.numerator > 0) {
                    return 0;
                } else {
                    if (this.numerator > 0) {
                        return 1;
                    } else {
                        return -1;
                    }
                }
            }
        }
        return 1;
    }
    
    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }
    
}

class InverseComparator implements Comparable<InverseComparator> {

    private int numerator;
    private int denominator;

    public InverseComparator(int numerator, int denominator) {
        
        this.numerator = numerator;
        this.denominator = denominator;
        
    }

    @Override
    public int compareTo(InverseComparator r) {
        /*
         * return 1, A > B
         * return 0, A = B
         * return -1,A < B
         */
        if (this.numerator*this.denominator > 0 && r.numerator*r.denominator < 0) {
            return 1;
        }
        if (this.numerator*this.denominator < 0 && r.numerator*r.denominator > 0) {
            return -1;
        }
        // both positive or both negative
        if (this.numerator != 0 && this.denominator != 0 && r.numerator != 0 && r.denominator != 0) {
            if (Math.abs(this.numerator*r.denominator) > Math.abs(r.numerator*this.denominator)) {
                if (this.numerator*this.denominator > 0) {
                    return 1;
                } else {
                    return -1;
                }
            } else if (Math.abs(this.numerator*r.denominator) < Math.abs(r.numerator*this.denominator)) {
                if (this.numerator*this.denominator > 0) {
                    return -1;
                } else {
                    return 1;
                }
            } else {
                return 0;
            }
        }
        // some number equals to zero
        else {
            if (this.numerator != 0 && this.denominator != 0) {
                boolean isPos = true;
                if (this.numerator*this.denominator > 0) {
                    isPos = true;
                } else {
                    isPos = false;
                }
                if (r.numerator == 0) {
                    if (isPos) {
                        return 1;
                    } else {
                        return -1;
                    }
                } else if (r.denominator == 0) {
                    if (r.numerator > 0) {
                        return -1;
                    } else if (r.numerator < 0) {
                        return 1;
                    }
                }

            } else if (r.numerator != 0 && r.denominator != 0) {
                boolean isPos = true;
                if (r.numerator*r.denominator > 0) {
                    isPos = true;
                } else {
                    isPos = false;
                }
                if (this.numerator == 0) {
                    if (isPos) {
                        return 1;
                    } else {
                        return -1;
                    }
                } else if (this.denominator == 0) {
                    if (this.numerator > 0) {
                        return -1;
                    } else if (this.numerator < 0) {
                        return 1;
                    }
                }
            } else if (this.numerator == 0 && r.numerator == 0) {
                return 0;
            } else if (this.numerator == 0 && r.denominator == 0) {
                if (r.numerator > 0) {
                    return -1;
                } else {
                    return 1;
                }
            } else if (this.denominator == 0 && r.numerator == 0) {
                if (this.numerator > 0) {
                    return 1;
                } else {
                    return -1;
                }
            } else if (this.denominator == 0 && r.denominator == 0) {
                if (this.numerator*r.numerator > 0) {
                    return 0;
                } else {
                    if (this.numerator > 0) {
                        return 1;
                    } else {
                        return -1;
                    }
                }
            }
        }
        return 1;
    }

    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }
}