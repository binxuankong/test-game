from tkinter import Tk
from application import Application

# Creating a window from the application class
def main():
    root = Tk()
    root.title("Test")

    # Application width and height
    w = 1280
    h = 640
    # Get screen width and height
    ws = root.winfo_screenwidth()
    hs = root.winfo_screenheight()
    # Calculate x and y coordinates for the Tk root window
    x = (ws/2) - (w/2)
    y = (hs/2) - (h/2)

    root.geometry('%dx%d+%d+%d' % (w, h, x, y))

    app = Application(root)
    root.mainloop()

main()