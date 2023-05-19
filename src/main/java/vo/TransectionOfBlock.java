package vo;

import lombok.Builder;
import lombok.ToString;

@Builder
@ToString
public class TransectionOfBlock {
    private String transactionHash;
    private String block;
    private String fromAddr;
    private String toAddr;
    private String volume;
    private String gasPrice;
    private String tokenContractAddr;
    private String timeStamp;

}
