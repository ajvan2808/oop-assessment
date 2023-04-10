# MANAGED ATTRIBUTES WITH PROPERTY DECORATOR
class Person:
    def __init__(self, name, age):
        self.name = name
        self._age = age

    def display(self):
        print(self.name, self._age)

    @property
    def age(self):
        return self._age

    @age.setter
    def age(self, new_age):
        # setter support info validation
        if 10 < new_age < 80:
            self._age = new_age
        else:
            raise ValueError("Age under 80")
#       setter should not return value


"""
    CREATING READ-WRITE ATTRIBUTE
    In this case, the getter method just returns the age value. 
    The setter method converts the input value for the `age` and assigns it to the non-public `_age`, 
    which is the variable you use to store the final data
    In this case, the class initializer assigns the input value to the `age` property directly 
    instead of storing it in a dedicated non-public attribute, such as `_age`
    
    Why? Because you need to make sure that every value provided as an age, including the initialization value, 
    goes through the setter method and gets validate that it's within the age range.
    
    If we call p.age at this moment setter assigned the value of instance param `age`.
    In short setter will be called once there's `=` operator, and at init setter is called
    created `_age` variable and assigned new value which is instance param

    That why self._age is valid though we not initialize at first.
"""


class Person_1:
    def __init__(self, name, age):
        self.name = name
        self.age = age

    # @property decorator allow user to access method like attribute and make it read only
    # or write-only with .setter
    @property
    def age(self):
        return self._age

    @age.setter
    def age(self, new_age):
        # validation
        if 10 < new_age < 50:
            self._age = new_age
            # return self._age

    def display(self):
        print(self.name, self.age)


if __name__ == '__main__':
    p = Person('Sun', 13)
    p.display()
    print(p._age)

    p1 = Person_1('BiBi', 23)
    p1.display()
    # p1.age = 20
    p1.display()
