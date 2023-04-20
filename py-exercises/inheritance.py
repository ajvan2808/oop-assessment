class Person:

    def __init__(self, name, age, address, phone):
        self.name = name
        self.age = age
        self.address = address
        self.phone = phone

    def contact_detail(self):
        print(self.address, self.phone)

    def greet(self):
        print(f"Hello, I'm {self.name}")

    def is_adult(self):
        if self.age > 18:
            return True
        return False


# child class of Person. is-a relationship
class Employee(Person):
    # pass
    # Modified base class method/ Overriding
    def __init__(self, name, age, address, phone, salary, office_address, office_phone):
        # Person.__init__(self, name, age, address, phone)
        super().__init__(name, age, address, phone)
        self.salary = salary
        self.office_address = office_address
        self.office_phone = office_phone

    def cal_tax(self):
        if self.salary < 2000:
            return 0
        return self.salary * 0.05

    # Override contact_detail
    def contact_detail(self):
        # print(self.address, self.phone)
        # Person.contact_detail(self)
        super().contact_detail()
        print(self.office_address, self.office_phone)


emp = Employee('Sun', 20, 'HCMC', '0908899900', 2500, 'HN', '028997788')
emp.contact_detail()
emp.cal_tax()