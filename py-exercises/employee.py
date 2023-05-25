class Employee:
    def __init__(self, firstname, lastname, birth, salary):
        self.firstname = firstname
        self.lastname = lastname
        self.birth = birth
        self.salary = salary

    def show(self):
        print(f"Iam {self.firstname} {self.lastname} was born in {self.birth}")