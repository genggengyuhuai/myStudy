package distribution.temp;

/**
 * @author lihaoyu
 * @date 2019/12/16 21:25
 */
public class PayService {

    private OrderClient orderClient;
    private AccountClient accountClient;
    private RepositoryClient repositoryClient;

    public void makePayment(){
        try{ // try 阶段
        orderClient.tryUpdateStatus();
        accountClient.tryDecrease();
        repositoryClient.tryDecrease();
        }catch (Throwable t){// cancel 阶段
        orderClient.cancelUpdateStatus();
        accountClient.cancelDecrease();
        repositoryClient.cancelDecrease();
        }  // confirm 阶段
        orderClient.confirmUpdateStatus();
        accountClient.confirmDecrease();
        repositoryClient.confirmDecrease();
    }

}
