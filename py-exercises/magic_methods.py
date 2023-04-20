class Fraction:
    def __init__(self, numberator, deciminator=1):
        self.nr = numberator
        self.dr = abs(deciminator)
        if self.dr < 0:
            self.nr *= -1
            self.dr *= -1
        self._reduce()

    def show(self):
        print(f"{self.nr} / {self.dr}")

    # IMPLEMENTING MAGIC METHODS
    '''
    These special methods are generally not called directly like this in the code, 
    but they are called automatically when the related syntax is used.
    So when Python will see "+" operator working on a user defined type, it will look for dunder
    add method in the class and will invoke it if it is present.
    '''
    def __mul__(self, other):
        if isinstance(other, int):
            other = Fraction(other)
        f = Fraction(self.nr * other.nr, self.dr * other.dr)
        f._reduce()
        return f

    def __add__(self, other):
        if isinstance(other, int):
            other = Fraction(other)
        f = Fraction(self.nr * other.dr + other.nr * self.dr, self.dr * other.dr)
        f._reduce()
        return f

    def __sub__(self, other):
        if isinstance(other, int):
            other = Fraction(other)
        f = Fraction(self.nr * other.dr - other.nr * self.dr, self.dr * other.dr)
        f._reduce()
        return f

    '''
    Two instance objects will be considered equal only if 
    they are same object otherwise they are considered unequal.
    To compare instance objects in some other ways, we need to use magic methods
    '''
    def __eq__(self, other):
        return (self.nr * other.dr) == (self.dr * other.nr)

    # Less than
    def __lt__(self, other):
        return (self.nr * other.dr) < (self.dr * other.nr)

    # Less equal
    def __le__(self, other):
        return (self.nr * other.dr) <= (self.dr * other.nr)

    # STRING REPRESENTATION OG INSTANCE OBJECT
    # User-friendly readable string representation
    def __str__(self):
        return f"{self.nr} / {self.dr}"

    # Descriptive string repr for programmer debugging purpose
    def __repr__(self):
        return f"(Fraction: {self.nr}, {self.dr})"

    @staticmethod
    def hcf(x, y):
        x = abs(x)
        y = abs(y)
        s = x if x > y else y
        while s > 0:
            if x % s == 0 and y % s == 0:
                break
            s -= 1
        return s

    def _reduce(self):
        h = Fraction.hcf(self.nr, self.dr)
        if h == 0:
            return
        self.dr //= h
        self.nr //= h


f1 = Fraction(2, 3)
f2 = Fraction(3, 4)
f6 = Fraction(2, 3)
f3 = f1.__add__(f2)
f3.show()
# WITH MAGIC METHODS IMPLEMENTATION
f4 = f1 + f2
f4.show()
f5 = f1 * f2
f5.show()
print(f1 == f6)
print(f1)