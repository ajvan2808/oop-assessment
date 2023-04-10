from employee import Employee
from datetime import datetime

class Person:
    def __init__(self, name, age):
        self.name = name
        self.age = age

    def display(self):
        print(f"I am {self.name}, {self.age} years old")

    # There are situations when we want to create instances objects of type Person from different data types
    @classmethod
    def from_str(cls, s):
        name, age = s.split(',')
        return cls(name, int(age))

    @classmethod
    def from_dict(cls, d):
        return cls(d['name'], d['age'])

    # Create Person instance object with Employee instance attribute
    @classmethod
    def from_employee(cls, emp):
        name = emp.firstname + ' ' + emp.lastname
        age = datetime.now().year - emp.birth
        return cls(name, age)


p1 = Person("Hank", 20)
p2 = Person("Paul", 30)

s = 'Jim, 23'
p3 = Person.from_str(s)
p3.display()
d = {'name': 'John', 'age': 35}
p4 = Person.from_dict(d)
p4.display()

emp1 = Employee('Van', 'Hanh', 1997, 20000)
p5 = Person.from_employee(emp1)
p5.display()