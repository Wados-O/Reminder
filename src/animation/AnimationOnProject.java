package animation;

public class AnimationOnProject {

  /**
   * In play animation we are going to show logo Animation on this project
   */
  public static void playAnimation() {
    Intro.logoTeam();
    Intro.logoPresents();
    Intro.emptyPlace();
    Intro.stringLoading();
    Intro.clear();
    Intro.logoProject();
    Intro.emptyPlace();
    Intro.stringDownload();
    Suspend.longSuspend();
    Intro.clear();
    Intro.clear();
  }
}
