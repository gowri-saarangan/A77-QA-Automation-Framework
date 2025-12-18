import org.testng.Assert;
import org.testng.annotations.Test;
import pagefactory.AppLoginPage;
import pagefactory.AppPlaylistPage;
import pagefactory.AppBasePage;

public class Homework24 extends BaseTest {
    @Test
    public void renamedelplaylistpagefactory() throws InterruptedException {
        //driver = pagefactorydriver;
        AppLoginPage apploginpage = new AppLoginPage(driver);
        AppPlaylistPage appplaylistpage = new AppPlaylistPage(driver);
        AppBasePage appBasePage = new AppBasePage(driver);
        //AppBasePage appbasePage = new AppBasePage(driver);

        apploginpage.setUsernamefield("gowri.saarangan@testpro.io");
        apploginpage.setPasstextfield("iVRbJcck");
        apploginpage.setapploginbtn();

        Assert.assertTrue(appplaylistpage.avatarisdisplayed());

        String listname1;
        listname1 = appBasePage.randnamegenerator();
        System.out.println(listname1);
        appplaylistpage.createanewplaylist(listname1);

        String listname2 = appBasePage.randnamegenerator();
        System.out.println(listname2);
        appplaylistpage.playlistrenaming(listname2,listname1);
        appplaylistpage.deleteplaylist(listname2);

        // Assert.assertTrue(basePage.findelements(playlist).isEmpty());
        // playlistpage.listisempty(listname1);
    }

}
