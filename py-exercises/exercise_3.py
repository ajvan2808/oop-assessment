# Highest common factor of 2 numbers
"""
    In mathematics, a divisor of an integer n, also called a factor of n,
    is an integer m that may be multiplied by some integer to produce n.
    In this case, one also says that n is a multiple of m
"""


def hcl(x, y):
    x = abs(x)
    y = abs(y)
    # first determine the smaller of the two numbers the H.C.F can only be less than or equal to the smallest number.
    # We then use a for loop to go from 1 to that number.
    # In each iteration, we check if our number perfectly divides both the input numbers.
    s = y if x > y else x
    while s > 0:
        if x % s == 0 and y % s == 0:
            break
        s -= 1
    return s


class SalesPerson:
    names = []
    total_revenue = 0

    def __init__(self, name, age):
        self.name = name
        self.age = age
        self.sales_amount = 0
        SalesPerson.names.append(name)

    def make_sale(self, money):
        self.sales_amount += money
        SalesPerson.total_revenue += money

    def show(self):
        print(self.name, self.age, self.sales_amount)


# s1 = SalesPerson('Bob', 25)
# s2 = SalesPerson('Ted', 22)
# s3 = SalesPerson('Jack', 27)
#
# s1.make_sale(1000)
# s1.make_sale(1200)
# s2.make_sale(5000)
# s3.make_sale(3000)
# s3.make_sale(8000)
#
# s1.show()
# s2.show()
# s3.show()
#
# print(SalesPerson.total_revenue)
# print(SalesPerson.names)


class Employee:
    domains = set()
    allowed_domains = {'yahoo.com', 'gmail.com', 'outlook.com'}

    def __init__(self, name, email):
        self.name = name
        self.email = email
        Employee.domains.add(self.email.split('@')[1])
        # domain = email[email.index('@')+1 : ]

    def display(self):
        print(self.name, self.email)

    # Cannot verify at initialization
    # @staticmethod
    # def _is_allowed(email):
    #     if email.split('@')[1] not in Employee.allowed_domains:
    #         raise RuntimeError

    @property
    def email(self):
        return self._email

    @email.setter
    def email(self, new_email):
        domain = new_email[new_email.index('@')+1:]     # lấy từ index sau @ về cuối
        if domain in Employee.allowed_domains:
            self._email = new_email
        else:
            raise RuntimeError


e1 = Employee('John', 'john@gmail.com')
e2 = Employee('Jack', 'jack@yahoo.com')
e3 = Employee('Jill', 'jill@outlook.com')
e4 = Employee('Ted', 'ted@yahoo.com')
e5 = Employee('Tim', 'tim@gmail.com')
e6 = Employee('Mike', 'mike@yahoo.com')

e1.display()
print(e1.domains)


# STACK ABSTRACT DATA TYPE IMPLEMENTATION USING LIST
class Stack:
    MAX_SIZE = 10

    def __init__(self):
        self.items = []

    def is_empty(self):
        return self.items == []

    def size(self):
        return len(self.items)

    def push(self, item):
        if self.size() == Stack.MAX_SIZE:
            raise RuntimeError('Stack is full')
        self.items.append(item)

    def pop(self):
        if self.is_empty():
            raise RuntimeError("Stack is empty")
        return self.items.pop()

    def display(self):
        print(self.items)


class BankAccount:
    bank_name = "Commercial Bank"

    def __init__(self, name, balance=0, bank=bank_name):
        self.name = name
        self.balance = balance
        self.bank = bank

    def display(self):
        print(self.name, self.balance, self.bank)

    def withdraw(self, amount):
        self.balance -= amount

    def deposit(self, amount):
        self.balance += amount


a1 = BankAccount('Mike', 200)
a2 = BankAccount('Tom')

a1.display()
a2.display()


if __name__ == "__main__":
    st = Stack()

    while True:
        print("1.Push")
        print("2.Pop")
        print("3.Peek")
        print("4.Size")
        print("5.Display")
        print("6.Quit")

        choice = int(input("Enter your choice : "))

        if choice == 1:
            x = int(input("Enter the element to be pushed : "))
            st.push(x)
        elif choice == 2:
            x = st.pop()
            print("Popped element is : ", x)
        elif choice == 3:
            print("Element at the top is : ", st.peek())    # return top item of the stack
        elif choice == 4:
            print("Size of stack ", st.size())
        elif choice == 5:
            st.display()
        elif choice == 6:
            break
        else:
            print("Wrong choice")
        print()
