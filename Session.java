/**
 * Created by guillaume on 5/3/17.
 */
public class Session {

        private User user;
        private boolean isGuest;
        private boolean isAdmin;

        //TODO Kontar Maryna changes these for Menu mainMenu()
        public Session(){
            user = null;
            isGuest = true;
            isAdmin = false;
        }

        public Session(User user){}

        public boolean isGuest() {
            return isGuest;
        }

        public void setGuest(boolean guest) {
            isGuest = guest;
        }

        public boolean isAdmin() {
            return isAdmin;
        }

        public void setAdmin(boolean admin) {isAdmin = admin;}

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
