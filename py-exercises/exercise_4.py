class Time:
    def __init__(self, h, m, s):
        self._h = h
        self._m = m
        self._s = s

    # Read-only field accessors
    @property
    def hours(self):
        return self._h

    @property
    def minutes(self):
        return self._m

    @property
    def seconds(self):
        return self._s

    @staticmethod
    def _cmp(time1, time2):
        if time1._h < time2._h:
            return 1
        if time1._h > time2._h:
            return -1
        if time1._m < time2._m:
            return 1
        if time1._m > time2._m:
            return -1
        if time1._s < time2._s:
            return 1
        if time1._s > time2._s:
            return -1
        return 0

    def __eq__(self, other):
        return True if Time._cmp(self, other) == 0 else False

    def __lt__(self, other):
        return True if Time._cmp(self, other) == 1 else False

    def __le__(self, other):
        return True if Time._cmp(self, other) == -1 else False


t1 = Time(13, 10, 5)
t2 = Time(5, 15, 30)
t3 = Time(5, 15, 30)
print(t1 < t2)
print(t1 > t2)
print(t1 == t2)
print(t2 == t3)


class Length:
    def __init__(self, feet, inches):
        self.feet = feet
        self.inches = inches

    def __str__(self):
        return f'{self.feet} {self.inches}'

    # def add_Length(self, L):
    #     f = self.feet + L.feet
    #     i = self.inches + L.inches
    #     if i >= 12:
    #         i = i - 12
    #     f += 1
    #     return Length(f, i)
    #
    # def add_inches(self, inches):
    #     f = self.feet + inches // 12
    #     i = self.inches + inches % 12
    #     if i >= 12:
    #         i = i - 12
    #     f += 1
    #     return Length(f, i)

    def __add__(self, other):
        f = 0
        i = 0
        if isinstance(other, Length):
            f = self.feet + other.feet
            i = self.inches + other.inches
        elif isinstance(other, int):
            f = self.feet + other // 12
            i = self.inches + other % 12
        else:
            print('Not implemented')
        f += 1
        if i >= 12:
            i = i - 12

        return Length(f, i)

    # OR
    # def __add__(self, other):
    #     if isinstance(other, Length):
    #         return self.add_length(other)
    #     if isinstance(other, int):
    #         return self.add_inches(other)
    #     else:
    #         return NotImplemented

    def __radd__(self, other):
        return self.__add__(other)


length1 = Length(2, 10)
length2 = Length(3, 5)

print(length1 + length2)
print(length1 + 2)
print(length1 + 20)
print(20 + length1)
