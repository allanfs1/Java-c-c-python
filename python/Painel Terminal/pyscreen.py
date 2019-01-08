import npyscreen

class text (npyscreen.NPSAppManaged):
    def onstart(self):
      self.registerForm("MAIN",Mainform())


class Mainform (npyscreen.Form):
    def create(self):
        self.add( npyscreen.TitleText,name = "File",value="Hellow Word")

    def edite(self):
        self.parentApp.setNexForm(None)


if __name__=='__main__':
 app = text()
 app.run()
