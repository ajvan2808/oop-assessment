from typing import List


class Course:
    def __init__(self, title, instructor, price, lectures, ratings, avg_rating, users: List):
        self.title = title
        self.instructor = instructor
        self.price = price
        self.lecture = lectures
        self.ratings = 0
        self.avg_rating = 0
        self.users = users

    def __str__(self):
        return f"{self.title} - {self.instructor} - {self.ratings}"

    def new_user_enrolled(self, new_user):
        return self.users.append(new_user)

    def received_a_rating(self, new_rating):
        while new_rating <= 5:
            self.avg_rating = (self.avg_rating * self.ratings + new_rating) / (self.ratings + 1)
            self.ratings += 1
        else:
            return "Rating from 1 to 5 only!"

    def show_details(self):
        print(f'{self.title}\n'
              f'{self.instructor}\n'
              f'{self.price}\n'
              f'{self.lecture}\n'
              f'{self.ratings}\n'
              f'{self.avg_rating}\n'
              f'{self.users}')


class VideoCourse(Course):
    def __init__(self, title, instructor, price, lectures, ratings, avg_rating, users: List, length):
        super().__init__(title, instructor, price, lectures, ratings, avg_rating, users)
        self.length = length

    def show_details(self):
        super().show_details()
        print(self.length)


class PdfCourse(Course):
    def __init__(self, title, instructor, price, lectures, ratings, avg_rating, users: List, pages):
        super().__init__(title, instructor, price, lectures, ratings, avg_rating, users)
        self.pages = pages

    def show_details(self):
        super().show_details()
        print(self.pages)


x = VideoCourse('How to be rich', 'Hanh van', 100, 4, 4, 2, ['Sunny', 'Gia Man'], 30)
x.show_details()
x.received_a_rating(3)
print(x)
