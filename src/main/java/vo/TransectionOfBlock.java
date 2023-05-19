package vo;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
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
