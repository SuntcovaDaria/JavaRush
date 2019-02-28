package JavaCore.task14.task1408;

public class MoldovanHen extends Hen implements Country{
    @Override
    int getCountOfEggsPerMonth() {
        return 18;
    }

    @Override
    String getDescription() {
        return super.getDescription()+ " Моя страна - "+ MOLDOVA+ ". Я несу " + getCountOfEggsPerMonth()+ " в месяц.";
    }
}
