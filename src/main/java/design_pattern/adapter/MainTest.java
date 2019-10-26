package design_pattern.adapter;

/**
 * 电脑读SD卡。现在要求不改变读SD卡的代码，实现读TF卡
 * 重点在于  SdAdapter 包装了TF卡
 *
 * @author lihaoyu
 * @date 2019/10/25 10:21
 */

class SdCard{

    public void readSD(){
        System.out.println("read sd card");
    }
}

class PC{
    public void readSdCard(SdCard sdCard){
        sdCard.readSD();
    }
}

class TfCard{
    public void readTF(){
        System.out.println("read tf card");
    }
}

class SdAdapter extends SdCard{
    TfCard tfCard;

    @Override
    public void readSD() {
        tfCard.readTF();
    }

    public SdAdapter(TfCard tfCard) {
        super();
        this.tfCard = tfCard;
    }
}

public class MainTest {


    public static void main(String[] args) {
        PC pc = new PC();
        SdCard sdCard = new SdCard();
        pc.readSdCard(sdCard);

        sdCard = new SdAdapter(new TfCard());
        pc.readSdCard(sdCard);
    }
}
