
class BankAccount:
    def __init__(self, name, balance=0):
        self.name = name
        self.balance = balance

    def display(self):
        print(self.name, self.balance)

    def withdraw(self, amount):
        self.balance -= amount

    def deposit(self, amount):
        self.balance += amount


class Books:

    def __init__(self, isbn, title, author, publisher, pages, price, copies):
        self.isbn = isbn
        self.title = title
        self.author = author
        self.publisher = publisher
        self.pages = pages
        self.price = price
        self.copies = copies

    @property
    def price(self):
        return self._price

    @price.setter
    def price(self, new_price):
        # validation
        if 50 < new_price < 100:
            self._price = new_price
        else:
            print("Price not appropriate!")

    def show(self):
        print(self.isbn, self.title, self.author, self.publisher, self.pages, self.price, self.copies)

    def in_stock(self, book_title):
        while book_title != self.title:
            raise ValueError("Book not avaialable")

        rs = True if self.copies > 0 else False
        return rs

    def sell(self, book_title):
        if self.in_stock(book_title):
            self.copies -= 1
        else:
            print("Book is out of stock!")

    books = []

    def add_books(self):
        Books.books.append(self)


def books_display():
    for book in Books.books:
        book.show()


# CLASS FRACTION
class Fraction:
    def __init__(self, numberator, deciminator=1):
        self.nr = numberator
        self.dr = abs(deciminator)
        # make the denominator positive if it is negative. For example  -2/-3 should be changed to 2/3 and 2/-3 to -2/3.
        if self.dr < 0:
            self.nr *= -1
            self.dr *= -1
        self._reduce()

    def show(self):
        print(f"{self.nr} / {self.dr}")

    # Multiply then reduce
    def multiply(self, other):
        if isinstance(other, int):
            other = Fraction(other)
        f = Fraction(self.nr * other.nr, self.dr * other.dr)
        f._reduce()
        return f

    # Add then reduce
    def add(self, frac):
        if isinstance(frac, int):
            frac = Fraction(frac)
        f = Fraction(self.nr * frac.dr + frac.nr * self.dr, self.dr * frac.dr)
        f._reduce()
        return f

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

    # To reduce a Fraction to its lowest terms you have to divide the numerator and denominator
    # by the highest common factor.
    def _reduce(self):
        h = Fraction.hcf(self.nr, self.dr)
        if h == 0:
            return
        # floor division
        self.dr //= h
        self.nr //= h


class Product:
    def __init__(self, id, marked_price, discount):
        self.id = id
        self.marked_price = marked_price
        self.discount = discount

    def display(self):
        print(self.id, self.marked_price, self.discount)

    @property
    def selling_price(self):
        discounted_amount = (self.marked_price * self.discount)/100
        return self.marked_price - discounted_amount

    @property
    def _discount(self):
        return self.discount + 2 if self.marked_price > 500 else self.discount

    @_discount.setter
    def _discount(self, new_value):
        self.discount += new_value


if __name__ == '__main__':
    print('----- Bank account -----')
    BA1 = BankAccount('AJ', 200)
    BA1.display()

    print('\n---- Create Books instance -----')
    BK1 = Books('957-4-36-547417-1', 'Learn Physics', 'Stephen', 'CBC', 350, 60, 10)
    BK2 = Books('652-6-86-748413-3', 'Learn Chemistry', 'Jack', 'CBC', 400, 51, 20)
    BK4 = Books('957-7-39-347216-2', 'Learn Biology', 'Jack', 'XYZ', 400, 60, 6)

    print('\n----- Instance methods -----')
    BK1.show()
    print(BK2.in_stock('Learn Chemistry'))
    BK2.sell("Learn Chemistry")
    BK2.show()

    print('\n----- Class variable & Global func ------')
    Books.add_books(BK1)
    Books.add_books(BK2)
    Books.add_books(BK4)
    books_display()

    print('\n----- Books written by Jack -----')
    print([bk.title for bk in Books.books if bk.author == "Jack"])

    print('\n----- Failed validation for price -----')
    BK3 = Books('957-7-39-347216-2', 'Learn Maths', 'John', 'XYZ', 500, 110, 5)

    print("----- Fraction -----")
    f1 = Fraction(2, 3)
    f1.show()

    f2 = Fraction(3, 4)
    f3 = f1.multiply(f2)
    f3.show()
    f3 = f1.add(f2)
    f3.show()
    f3 = f1.add(5)
    f3.show()
    f3 = f1.multiply(5)
    f3.show()

    print("\n----- Property selling price -----")
    p1 = Product('X879', 400, 6)
    p2 = Product('A234', 100, 5)
    p3 = Product('B987', 990, 4)
    p4 = Product('H456', 800, 6)

    print(p1.selling_price)
    print(p3._discount)

    print('\n----- Static method -----')
    print(f1.hcl(3, 4))