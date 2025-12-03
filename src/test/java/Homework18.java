import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework18 extends BaseTest{

    @Test
    public void playSong() throws InterruptedException {
        navigationpage();
        emailaddress("gowri.saarangan@testpro.io");
        password("iVRbJcck");
        loginbutton();
        Thread.sleep(2000);
        searchasong();
        Thread.sleep(2000);
        viewallsongs();
        Thread.sleep(2000);
        clickfirstsong();
        Thread.sleep(2000);
        Assert.assertEquals(driver.getCurrentUrl(),"https://qa.koel.app/#!/search/songs/tunnel%20of%20lights");

    }
    @Test
    public void playNextSong() throws InterruptedException {
        navigationpage();
        emailaddress("gowri.saarangan@testpro.io");
        password("iVRbJcck");
        loginbutton();
        Thread.sleep(2000);
        searchasong();
        Thread.sleep(2000);
        viewallsongs();
        Thread.sleep(2000);
        clickfirstsong();
        Thread.sleep(2000);
        //clickplay();
        //Thread.sleep(5000);
        soundbarisdisplay();
        Thread.sleep(2000);
        nextsongselected();
        Thread.sleep(2000);
        //nextsongbymediacontrol();
       // Thread.sleep(2000);
        playimmediatenextsong();

        Thread.sleep(5000);
        pausebtnisdisplayed();


    }
    @Test
    public void playnextsongbymediacontrol() throws InterruptedException {
        loginpage();
        Thread.sleep(2000);
        searchasong();
        Thread.sleep(2000);
        viewallsongs();
        Thread.sleep(2000);
        clickfirstsongbymediacontrol();
        Thread.sleep(2000);
        clickplay();
        Thread.sleep(5000);
        soundbarisdisplay();
        Thread.sleep(2000);
        playimmediatenextsong();

        Thread.sleep(5000);
        pausebtnisdisplayed();
    }
}
