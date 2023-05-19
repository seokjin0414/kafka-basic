package vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class TxOfBlock {
    private String transactionHash;
    private String block;
    private String fromAddr;
    private String toAddr;
    private String volume;
    private String gasPrice;
    private String tokenContractAddr;
    private String timeStamp;

}
