import io.vavr.collection.List;
import io.vavr.collection.Stream;

public class Day3RuckSackReorg {

    public static void main(String[] args) {
        Day3RuckSackReorg day3 = new Day3RuckSackReorg();

        String testInput = "vJrwpWtwJgWrhcsFMMfFFhFp\n" +
                "jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL\n" +
                "PmmdzqPrVvPwwTWBwg\n" +
                "wMqvLMZHhHMvwLHjbvcjnnSBnvTQFn\n" +
                "ttgJtRGJQctTZtZT\n" +
                "CrZsJsPPZsGzwwsLwLmpwMDw";


        day3.totalPriorities(testInput);

        String mainInput = "BdbzzddChsWrRFbzBrszbhWMLNJHLLLLHZtSLglFNZHLJH\n" +
                "nnfMwqpQTMffHlNNLllHnZSS\n" +
                "cGpcMwfppfqcjcTCBBzWDsDbDrjzWz\n" +
                "LhfjhcdjcGdhFfdGfdjdvwCCZMvvLvWwMLCLSwZC\n" +
                "rDnsbmptPmlbQMCrQWQQBZQW\n" +
                "gltgVPngDPbptPsbPzVgmDldfTdfczThjJJjfMcJdFHjjH\n" +
                "dGlgDflTLLLrRLTLVdQLcQMnbvHbbFzNNvMbnHHn\n" +
                "sZjWJJCSjWqfCqSjSmJSbFvCzBMBBzHncHNvMBHN\n" +
                "twqqwpZwfrlwRwDGDR\n" +
                "zCGGFTQMQrsNRNGZdR\n" +
                "cLLQgPDpgcgmvPRHrwBdvrNZ\n" +
                "glWpmJWQDcJpQnpjSmbhFtMnqFfCVTCFCFFM\n" +
                "zNZWFNZBFrGTdBcZZBdJTrGrmgvppgDHwHmgVHCHCvCPDjzC\n" +
                "qtqqPnLSfLwvjvvgvvqH\n" +
                "MtbLLLQbRfPRfnbnnLMtnsbdBNsrGWNWcNcTBWZrrcrWcJ\n" +
                "sZwstbbDVlHtbhcrhhZLrRpNQN\n" +
                "jqGjjFjWnzWGgqWjJJNphnLMRhLhcrhcrSLN\n" +
                "qCJzFJdvmHvbtpbb\n" +
                "ZSRsvvQvZpsRQGJghClPCwGPChCP\n" +
                "FVdMLDdtDRdDcBtmcVFntwgJJTlnNPwJnlTlwlTPgN\n" +
                "VqttMWFmDbjbzrSWRQ\n" +
                "TsDSBcwshdwSCrgRWZBvgGRG\n" +
                "LPVJLqqJbbzpFqwpbvgGRmZPrmZgCvCCfr\n" +
                "tzJlJzQllFLqtwHhjNSdtthjDhTN\n" +
                "fsDLDDnwvnSdqLSsFSDfsLpbgVttPMpPNjMWVMNfpjgW\n" +
                "jhHmBmlrTBBHRPVtMZbppNPPZB\n" +
                "JmTTrTmjRTJqSQQSFqQw\n" +
                "HPzZFgPFMCHJCcZMcDQGwpLqPLqppwhGvv\n" +
                "BrWRqbqRsTSTqNddrVrthLQVwnpwphnvnDnGvGDn\n" +
                "tSbBfsRbTfqjJqjCqm\n" +
                "pCqrqzmqZzrmCCvCJwJPBRwJBWBmwWBJ\n" +
                "VqbqbjFLFfSHnfctBwDdDFTwtRRTDF\n" +
                "LVcnbjHLSqHnhbSGGppCMMZMphpNrQ\n" +
                "PhTcTPsSPCMvvhhMRPttbNWfNsWFNfWWtpNw\n" +
                "rdQrDbJBVVjrBVdLjHHHWNWwfHtzzNtFpZZptppg\n" +
                "JJVGGdddjDjDJmdjGqqRSbPMTvcRlqnnMlvT\n" +
                "SqGfTrBlSrrrfGGQvCnqZhZmPPhvJh\n" +
                "LdVNwgsjdjHmjWwDsDpwsHWtnCnQQQQNnvCnbJZQbNbtZZ\n" +
                "DjssDHLLVppDssdLspswFLVjzfFMTfSBcTRcrFSBzBTzmGzr\n" +
                "JSJJqlldpJlcdVWMlgMJrcCjrhzHCwTjHrQzwTzZ\n" +
                "bBvsGBGNFDNRFNFBRDPsDDHCChhhrZRQQzhjhCjTzWCr\n" +
                "FvbLFGDDtWDFBnPGFDWGqJMgJpSdVStllttlppVS\n" +
                "clpBdBQBsqGpQbVdqTTWRTSFgLLggffg\n" +
                "NzvwmHvZtZZgbDSCLDmfmm\n" +
                "jPJjthHzNwPvvjwjNzPzztZBlrccpbVGBQhlGBVlrpnpBs\n" +
                "NmFFGlGmzCrNWHvFmFWCFvQPTdDDlbbdgJPtgbbdPDcc\n" +
                "RwfBqLwZqffqnPbdDgVQDdtRbT\n" +
                "hnptqLMMLwqjMMjzSzHmhvNNrvvhhz\n" +
                "hqVrDdPdVDqjsDrjjqsfrrWlctvHJNLfvNcLHNNZRNZHvfZL\n" +
                "CSnWQSGBBSnmBnTmSbQbNZZMJNJMccGNHLZNNvNv\n" +
                "gFnmBmBnTCpwmBbgWVqjPsrsjplVrjlqPr\n" +
                "vgVgJJCphzFjzbwljwww\n" +
                "PWmfDgrPrPWlSWqSWlSZ\n" +
                "rrTHQTGTPHDDHgPrcrcPmDPhdtGvnvNnttJCdJhtGVnpdM\n" +
                "DDDhNgWNLWgDqDgtgtwSngjVSQdf\n" +
                "cvFrcGmBrrrCdSfSJQ\n" +
                "mBHzFFvFzmsBspsFsZqhqbWlWdPDlLHbqZ\n" +
                "TLNpGpRzwGQLLQRTwdvWdWbdbgdBlblb\n" +
                "FJDVzZzHfZHVzcHgnvHnvngvvc\n" +
                "MzDVSmZPPrqhGmCqQqLR\n" +
                "mqHWcBHVcgsbhhnTrrTg\n" +
                "fWftGtfJpwJMSdFDLFSGDGFnnNrbrhTNsZnrhTswZZnnsb\n" +
                "dSftppdSFStLDpQfLjWHQvWBmmqVjCqcVv\n" +
                "frfNzgvzzzJwJqpRcP\n" +
                "VdVSnGnHqhDDTdqhdLWmjMTmjMPjPmTsmsmjmR\n" +
                "BdGLSWtBSWDtVqdSDVGqtSSHFZFZtQbZlZfNgFffrgNrvgrl\n" +
                "jBVSjsJcLcqqjtgcmRFRNFFzFm\n" +
                "CnHnWQQGGWnnCnfvCTmZRZgNtfZtNDZPtNDtzl\n" +
                "mWWGGdmQQWwrHHMBBBhrBVqshBLBSL\n" +
                "cLtFcllvrslGLcLHVzDZQzzpznWzQtQZ\n" +
                "TmShfSSPJRRBBfSgmdfBJhDNVpGzVZpzQgZgbWzpnDGp\n" +
                "BhJPfSqdhqJRdBdPqTJBChvrFlHvvCGCccHsMscvrHvv\n" +
                "zfddZTpZLzLDfLtDCttdTfZPnlcPcnhjPDnlcjMchDPjnP\n" +
                "MQsFvFHJsQvmNvvswljgbPbwlwjnmcch\n" +
                "VFVqvqFQHqVJRVCBLpqTGMzCqtMZ\n" +
                "PZdVgNdQQcdcZQtGhnHtBlvlvWTnbBHWWH\n" +
                "CDJmzqFmMmLfqmzFwqfzfwMRvpRbTWBBWDnlnbnWnTNTnB\n" +
                "zFfffjCqwLJCfrCFjCLCzCMsjSZjQNPhQGVSQQZhsGjGgd\n" +
                "nbHntnqPQwTHwQVC\n" +
                "BzfSZSpcBZpzpPhSBjRTCBWTTRWTTTWR\n" +
                "pvZpzPzNfhddJGmmNnJb\n" +
                "GwTgWlvbgTwMrbwTrlWvwtHBNtNvBhBtdZcShHDtNS\n" +
                "PnndmnCmnJFnsmRdmFnnZDhRRScRQQHDtDNtcDQS\n" +
                "CLffLsmqqpJljVdlpMpWlr\n" +
                "dPCzBLTSLqmqdSCsmrTDVQjZfjfVVZnZhhhLGQ\n" +
                "wwFpgvPJNwgPPwvZGnQhbZQQFfQZbf\n" +
                "WvRwwJpHHgpNMNqdTdCdqrmHBPtm\n" +
                "DbWwjSGFSFfwGfCwDSSPPjLhgrrLWRJRgggJphLzpJLq\n" +
                "lQTnMHdcQBvlHMMZBcHHTrbzpdzgqrpLdqzzVRVRVV\n" +
                "vlvlNlBQvBZTQBnHnQTTBBPwPNCCsfSFmbSFfmGPwFmj\n" +
                "hGGQtbVjhRqlmqqrmDlpmw\n" +
                "gPMZsMgdssCPPsvrgZcTZTPSnnLLnBWDwLmwWwBnmWSnWNWB\n" +
                "TsvgMPdcgCfMdcsZJRQhVfVRVQFFQGtr\n" +
                "NfpFTTpFNbpZMRFrJMMMCv\n" +
                "dWJPngDWBtPVBdPVGHZzCGHZrrvZRSMSzv\n" +
                "WDDDVDPlWnLBVgnsgJmQJNqThNmbjlqbbh\n" +
                "vnznqvfrzzVzrvvnfVqztBtGbMCdGmCcdccJccCLCcpSSgcL\n" +
                "RQsDsljDlhssWshHhlhsHTlLbgJLpmgbbcMSpSSbcSJgjd\n" +
                "WswhhHWlRTsQDwWHTRhsvNVvwqzfVmNBtZNmnzzq\n" +
                "cjcPfLlQtPsZQlfHZJqVSFdVwmSRRqSSddwDvF\n" +
                "MgNbBgzgnwdPRFmSPn\n" +
                "CMGbNNMhCMzzPzBpTNPGBclLcLfsptHQfQlZssLcLf\n" +
                "slsdfpSlllpTVJJGgGDgHMdV\n" +
                "wrBQrbQrhQcpbQrhLwRBrjVVgGGPgZMtZMVhgMPMGHPg\n" +
                "QQwRnrwRbbRcmQmrjRnjpvNsNTNSlTmsTqCSvsNSWz\n" +
                "GWNwppdHdpmzgPFPCRmlCBPB\n" +
                "bSrJhJSsMhrJMDPRCPBlwVCtVSLV\n" +
                "QbsbwqQZvrJhhQrhZZrhchTfnTWGNvWpNnjHGvGjNdGT\n" +
                "NMZGmnMBWmwmNnGwHrHvHzfrvrVVVj\n" +
                "pSbDRLgbpJDPpRZRQjjFqVhhDFjDVqfrzv\n" +
                "sQQscLTZcsTpRsBnmlBcdCMBMtlc\n" +
                "hwWslbGWbRvLZvcscZ\n" +
                "gQnmmrNTmSnTfgwDwVwpJvJPJzLqLJTLLvRcZz\n" +
                "mrmnSrDNNQSmmwdggrrDbHMGhtdtGhGlhtClMGhM\n" +
                "qQdlGcvDQDQvDdmtPmmmlStbjSrm\n" +
                "CpNhzWTCTRznBMvwtTjMrHtSvj\n" +
                "nWzsfZCsBhNpZLgGdQDddvqd\n" +
                "ggjTjJWDVVVRTwQcZWvchshWhs\n" +
                "LmFfLfSmBtCttNLfCFBPFNBvvvhrcQdvsrsdSwdqcwrwSw\n" +
                "CHttltmlPLMHRTgJQDgRDTMb\n" +
                "RPJgCdhgPPSzvWDcCfGHDcvf\n" +
                "HbrrwBspTwWDDnqbZjjD\n" +
                "rQrFsrsstQMQHJdHQm\n" +
                "GVwQVGBZBNQwsjdNcMMlgJNPgj\n" +
                "SWFfSzTCSWFCSpgnJLSjpMdc\n" +
                "FhTbvrzrMrDCVHsVsHGBtHwv\n" +
                "FsqjjVzFVWFqRRWBssdpNSBHwJpHHJJdddSN\n" +
                "lQgmhvbTcgTgfhTQhSCFCGJHSlwNtJdGHG\n" +
                "vgZPbbfMhbTmchhjRFRnsDRPWVqzWz\n" +
                "cvwfjjcJjqhctvSpCgCFVhrFCrpC\n" +
                "mRsQmsMlNNzznWQlRnsMRQlSCpLNbpwSSSrwFLDFLLLgFp\n" +
                "zznlnGlmRmMlPZnGQzMszMRfccTjcBJjtJtJjqTZtfwBTt\n" +
                "PtCwCCVqbjNNqqvGssPmHGsHMfPH\n" +
                "dcddcWFDJJJcLczhWQdcDScZvHZgpGfsvMfSmsggSvvnvM\n" +
                "TTQmTDhdQQzdRwjBVrRwCwBbBr\n" +
                "BnBsFHCrcnBrMBPSmMSCmrcFqnZLddLhdhdGLvqLqgqnLJJp\n" +
                "WfjTlNVDTtjzNWTlVMWNlTwTJphdgpvJLGLdgghZvGLpwddq\n" +
                "zVjbVblVDlNTlbzTzDjllDTzHmHCsmcMHcSBrCBbrHBcBPSC\n" +
                "ddlcGQlCjQNGQmPLslZTlmTtfT\n" +
                "MDzMwSwqpzpDRpWRJwgZhttrZmTPfZmrmtrMZZ\n" +
                "JSqRBpJzwgDDpqDqvpBRdCjbCjQCFCbHvdGPjdHQ\n" +
                "bwzPwGLZMsbJMPPLGLMQzbhhQRvWWtVqVhgCVtWWQDqt\n" +
                "HddrHFnFNpVnVLhnvLRV\n" +
                "NLdrFjHTBrrdjFSpFmNBmSfZMwZMJJfSffbwzwPbczbJ\n" +
                "QTWSzTTLwTfwflSNJRdvGlRGcNgJBl\n" +
                "FnmmqrqbBBgRbHGc\n" +
                "MFZqrCVCqmZCprspFZmnnMsDfzWzDwSfjSwPQPTLhffwBLwj\n" +
                "npfgFRTZRRnDZLdgRfRrrjcWzGpWGGGQrjjWpP\n" +
                "vblVbvSShhVzHWjzzlrPWG\n" +
                "bVwqvCBtShqBhCCtqhNqCJRTTBDFJJLnJgDRWFBnWg\n" +
                "nHDNQvgvnNZHDnsGcjfNTrTfVrfL\n" +
                "SRWFSBRLtSFqjTrVVcsVjTSG\n" +
                "BdBbRttWBdbdWdbppmZlLmgwHvgQvgLZ\n" +
                "PQRZlpDDptQSclBMGVBdhVFGBMpf\n" +
                "nnrsTCWjLJsnsSMShhGJfwffwV\n" +
                "vjzqsjqgSHbbtvHZ\n" +
                "DgFmbdSDZbPgLbDDmFwZwgLSfccGcGvnvvngsGGnsGMNWsWs\n" +
                "HqztHHhHVhHjhRRhJtCVBCfNprMWpcMMJfsvvMsGscpG\n" +
                "tjVtBVTBtHHqCRqtzQwTPSNdSwPTTbPFDdml\n" +
                "sbmBmHZbRRRmwBmsSjHzRjmSCNFLNLLQNQhFgtQLzNztlrff\n" +
                "MpqPPDPVnGqrJpcqqJpMVlgtlLFLChCgChCCQgCtCD\n" +
                "VdcVVJvdrVWHbwHWBSSBRb\n" +
                "tPDVBzzNSNdDSQpMQMTQJMMQMN\n" +
                "LqSWSmbsmfQTTGZMWGCW\n" +
                "cLjLcbrjqmvfqLbfmqLwDBBzSHPzlwzcdBlnnP\n" +
                "SbnHrGHSrrhHJBrrScDfcPDMfpPGcGcpDL\n" +
                "QTpmpmmQWlZsTvVQDMgggFLgFcPf\n" +
                "zsCNlltCslzlTNsNlShwdJCpSqdHrBhpwr\n" +
                "JZmFrmLGjFZdDGrrVTvzmPVvRRVzwzzl\n" +
                "WBnfMDBqMsgDBqpBvzwVlCwRTRRPpvlw\n" +
                "WfghfttggfSnnqbDftfqSBBDQdHhZFFJrrHFjGJdGjFrjQLj\n" +
                "rNLRjrlVlrFRJzlsjrVlRFGCmnMtftgCNDDgDmCfqNgPNM\n" +
                "SpdBpdHbpHWhZqnCdtCGggqCPn\n" +
                "QHHvvWwWhwVVQRscVzGl\n" +
                "QffLtMQGMQfDMMwMTJwqWHvH\n" +
                "nSSFznjFcfjTgVJTJjvT\n" +
                "RrBpcfSNpRBcFshrCtQrDGLPQb\n" +
                "GctcMldStGwPPbcLsQTV\n" +
                "jhnzDgnHnnfPVwHQTTLTds\n" +
                "gBgzDDhzvqdGGvrtdvtm\n" +
                "PPwRWVTvRvPVLwRpMlzmbmsbHWjbbs\n" +
                "dFTFCNfdjzjFjsMF\n" +
                "SgdffSTrnnqCgdqgcNrfSZqVvVLRDPJZQwJBLPQPtLZwJJ\n" +
                "HSzDQftHphTBHFhr\n" +
                "WMmJsMJNLWNPmmsncjMJcjtvwggVvhFFFhjrVwrjrjppvT\n" +
                "WWPsJJCWCtZZZRGC\n" +
                "SfFZQDRLgpLlRgQRRRFWTsbhBhgTjbWBjhshgw\n" +
                "tHVNGjtzzHvMMJJhrWJNrTrPbP\n" +
                "jvVVvGCGtCmjHtdHzQQfDpSSlDRnFfQFmR\n" +
                "ZBBPfVVPPrVmrWZJzNdPznbnbSzznP\n" +
                "gvgpGqFFMgMcGgwLwGpcJNZSTZbdbdzNNSlqbTnn\n" +
                "ssZLgsMLQvcFpVrhCsmtWHjrrW\n" +
                "nFvhRnWWzBRPHQqcqqCqmFbd\n" +
                "SJDJgVprLfDfbJmHmWWHQtJW\n" +
                "wVsgWVSTgLjfSsVjVBRvRNwwGGRhNZhRMZ\n" +
                "wTRrRBCTPTBPlgMqgHCqggHLgg\n" +
                "dmDzpQpBdmWmWzzzDFzjGNMSWLSgLVGGLVNSLgSg\n" +
                "JbFdmQQJpjpptQbdJJmDmdtnZhZRflTlnTrTlrhBwPPc\n" +
                "jwSwssQbwbStlhRgtsVstn\n" +
                "zPzFdFFZccPDgntzVHHgghRz\n" +
                "vVVdfFmZPDMWZZBmGQbwJJGCLwwMwJCS\n" +
                "PLLffLFqqNLwSffbnVzzRf\n" +
                "lsmgTggChrgDtZsZVblMVJMznVnwMBnb\n" +
                "hDZZTmZvhTgstvwNFdqpWQcqvP\n" +
                "mmWwpwqtmmHTqHpprRZQPPZLZWSFRFRB\n" +
                "gzcgscgbfvhRRNZQRRQPvr\n" +
                "JsjhcshCfJgrrpttTCTplH\n" +
                "TvNrvNrJfWWvtJLTHhvZZhQQwVGZZhbV\n" +
                "mFCPmBMPlPsPPBsMFPszbHQJwwHHhbZVQVzjhGHZ\n" +
                "qmlBsdCSmJBmsBBMnMMTDWDNcLrDprSNcWDNrW\n" +
                "HSnHCVqTddFHSVqFqdStSQGQwRzQCzCRzGRRGNPQwz\n" +
                "jhlBpgNvlfZjlfvmpgfgfBrMRRwMMPPLQMZRPMWMMZPQ\n" +
                "hflfpgjfBfDcpchlpvndbHFDdHqSqNVqNVdn\n" +
                "QBfhlVNfHSZHfVCVHSQfZfTCctdvdDTRtjDCtTRsjsvj\n" +
                "brrWWqzFWzwWbswDchhTRtDhjT\n" +
                "gbrFLnpzqrWPgqpLWrhnHGZlSfLfHfQBGVfHHNVG\n" +
                "hcFmVScmQBVhtcvfHLfvHSnbHRLn\n" +
                "lzQqlDqgpWPvJfRnlNJvww\n" +
                "PjCCCPgDgqGzmMtCQstZmBFs\n" +
                "GrnrHrmVVFMFhSSbSfhR\n" +
                "zjTqLtBjjdWdWTLshMZMDbPNRMSSqSPNfD\n" +
                "dTWjdtwWhjWTBzcnrpcwmQpCwcpw\n" +
                "BgtVBsgVVJhgGsSGJbghJqbsjLfZmLjmmtfZndNNZFFZNLdm\n" +
                "MHTlzlwHSvPvzMSPCTMQCNZdjjmnfQjdZfNLjF\n" +
                "HMDTwPDpzrTzpScBghDbVqRBgRBJsR\n" +
                "qjCsTmrrnnCmhcFrCjqmThRlbHGvJGvvvbRbbJRcQJRG\n" +
                "fVBBTfMdSZLNZgPdgglGRdbtbtJRllJWJtWb\n" +
                "TSZZSpNMPBLgpZLVgppBDFhzDmjrnzhjssFqDhzFnn\n" +
                "MDtDMWmMQmdzmMMqvlGfRcjzgpcPPjczPl\n" +
                "sZsHJWNJFJNbWFBhFBnnbVclbVVPglfcRggffGGpjl\n" +
                "srHWLNZZJdSLSdvDMw\n" +
                "BFqsPnsZcgnncggccqsqqpDPtDWPpPNTNSNThrWtSj\n" +
                "dQbfQQJJdwdmFRbJLRJdMrfDWrjpDrrprhDDDDNWWD\n" +
                "QGwdJmCFJZvGsvvncB\n" +
                "GRRNSjrffGTSPrNTffSgcJTwWJZbbZvwvwtVwWVJZv\n" +
                "CMcFsqmBQzMzshsBQBQvLWmJVwZtpJLJwJLvwt\n" +
                "qBzChnQlzMcRSnnRRjHGGg\n" +
                "dPPbPWNdTBbDpHPHpNsgzvFlglvHzvSFzCFF\n" +
                "fntqhGhRMhnnnGGCVMRhCVlSjswFvvjzjSzvQVSgsl\n" +
                "MMqqJJRCnMhZLCRhtPNrpZPDDWTDTrNBmD\n" +
                "VjVGNTNlNchVjNGRWrSWWtZtRrzncR\n" +
                "BTbbbwDmCDLTbDwfHmzZMmRrWtzPrZSZtrrz\n" +
                "qDLLqvwLBsfBbBdQFQTJhqThVTQJ\n" +
                "qBqPBGZflhrWznzZZdsnzv\n" +
                "FmHRcCCsCDwDbjtzdjWbdz\n" +
                "cTRwCCNHFNmwRgmFTNCFTJqqfqPJsPhPBlsrsfGf\n" +
                "JTNhhNrCTcWpJJcpWw\n" +
                "LLdLsfMsdStbtggLbnTpwfWDzpjvnnjzcz\n" +
                "MqSZsgbMbGFbZtgTSZSFSLhhmHlBQlmrmrPHHCPPZPBr\n" +
                "GgjjgpGvpJJtjgvPrJttsLjVwCsQsQNLsfLfMVCl\n" +
                "RddqZqzcZdSWcHdcqQfQLMwVflfNQNMQ\n" +
                "FncWTRcFlHWFmcFTgPJhGvDgpnnhhGtG\n" +
                "ZGPFJsPQCbZCCbgz\n" +
                "nrvrnGWTwwqTBRcpCRRg\n" +
                "DnGWDldNmSLSMdMQ\n" +
                "ScDmPPPmjmjjWgtdSmdmCnNqVQVVrNRTZTQTQDHHZGNH\n" +
                "wbbMhLvMJpRwJQrJGHqQGrQHqr\n" +
                "wzhspwpppswsMFLmtnzjdcmdPRWPtS\n" +
                "fPlLTtBlTjDbWcTMJcncWqss\n" +
                "LdvLrLpCRRQQmvhhVNpwRMWJZcFMZWJwJFFFwZsGcs\n" +
                "prrRVpvvRVNmRvvzHjHPlzPLSffbbPHS\n" +
                "bbCbzsQbBzbBFbFzFfJHfVJPfVPtzZttpm\n" +
                "hwvrjDDwjcDcvdnNvwdnwwDPpNtNMVtPpJpRmVMPfmtVZR\n" +
                "mmqDWjhcqhwvDDdTsSGGCbQGSBBLTGGl\n" +
                "wthtwrBQhhSrqJJVLMRPPtJLPF\n" +
                "vbmbZqfqgsfHmcllmLLJNLJMNFJNNvPGJn\n" +
                "jHlDscllClCCgbZzhWqBzBQzprWCqS\n" +
                "DwpDlwDwllhJwbDFNDwFPhDnQnZZzVVnnBrtNznzSSzZrr\n" +
                "MHPfWRTgWzTQmSTTZt\n" +
                "GdPjHLRMCfcGvwqDGbFq\n" +
                "NGdNpDPdNGLppLpwSNFFFDLwnnZbMnrHlHZQcHbcnHQcPcQM\n" +
                "jBgBsjssgjWJVGhBfhvJVnMlbnZQVrrrlHCcCZrl\n" +
                "sRBgvRffhhtvtBgvjgttWBJTLmFLLwdwzFdqLDDDqFGdLFTd\n" +
                "RBzRGRGBgnrPJrRGGWWbDggZTSTVZVFFSVZZdw\n" +
                "tfmLhjfshNNsqpppfjHdwVdQZbVbQFVVTmSVDV\n" +
                "jvqtwHqCNLNsNhNfjssLCzGJWcBRJRBCBBBrrWnGrG\n" +
                "cGDBdNFdNdDStNtGdGQGscDMvZjjZWMvMLjsjjLZjLsJLv\n" +
                "fbRnRzHVPClfRlbbmfHRlPvZvMLpqjvZJqZMpzMpZjBZ\n" +
                "gfbfBgCHCPVNhNGgTtFDcF\n" +
                "ljjvLZvvllFnlLJLJjLWFQrVssFpsGMFpNMGsr\n" +
                "qbHSqHTcHChqCmTSRqqBVpVdBQsVQQGHdMprWV\n" +
                "DbtcCqRhhTRmDnPMlLgfgztlZZ\n" +
                "QtMQzPZcbtGgTtLvtf\n" +
                "HwcDsdVVDnNSGLhwvffJvfTT\n" +
                "CSsdSHNmSDHcCqqcrrzQcC\n" +
                "nDNDfmMnmDJRNfJJdMDRBdwjcTtsSHvBTswTjwLtsCts\n" +
                "QcbQrZZggGWVVWbZZjStswCSCCttGCwLvC\n" +
                "ZgZgbzVglVbchVVrVhFWWpnnpNJmJMqDfMJnMRqNDDMD\n" +
                "WMfNvsjWGjsqFjqTRRQVJztDzVmJHbft\n" +
                "ZPhplcrLrmzQGzmz\n" +
                "ZPddLPlcSclhZChndMvgTjjWNGWMGWBj\n" +
                "nDLjMchghDcljfjffpfsqTmGCTGszGZVVzHV\n" +
                "wdFJPFrQRwSNbjVQCTGsHZHmHCHs\n" +
                "BRJJSddvdBrJwrBRNRFRSPRjvclLpWhpglgWpLplltnMgh\n" +
                "BbVRzMcpbMNMHMTJmWdljdlJjT\n" +
                "GtsqFnfvGSFqGfQvgnWWZlLlLjZWtWldPmlT\n" +
                "sSsFqsqsGghwQQmfGRHbbVczbwwBpBpHcw\n" +
                "BBFCBJCsGJBBgvgsvTlVhgNg\n" +
                "ZnLdjRQddLRnZrlScHRVTTSHhRvg\n" +
                "fnnjZLWdrnqdWrrPLddqVqBzGDJJFGCBDfJmbDzFMbmB\n";
        day3.totalPriorities(mainInput);

        day3.badgePrios(testInput);
        day3.badgePrios(mainInput);

    }

    private void badgePrios(String testInput) {
        Number badgePrio = Stream.ofAll(testInput.lines())
                .sliding(3, 3)
                .map(group -> {
                            String badge = group.reduce((l, r) -> List.ofAll(l.toCharArray()).retainAll(List.ofAll(r.toCharArray())).mkString());
                            return priorityOf(badge.charAt(0));
                        }
                ).sum();
        System.out.println(badgePrio);
    }


    private void totalPriorities(String testInput) {
        Number totalPrio = Stream.ofAll(testInput.lines())
                .map(line -> {
                    int mid = line.length() / 2;
                    String left = line.substring(0, mid);
                    String right = line.substring(mid);

                    List<Character> distinctDoubles = List
                            .ofAll(left.toCharArray()).retainAll(List.ofAll(right.toCharArray()))
                            .distinct();

                    Number sum = distinctDoubles.map(Day3RuckSackReorg::priorityOf).sum();
                    System.out.println(sum);
                    return sum;
                }).sum();

        System.out.println(
                "TOTAL " + totalPrio
        );

    }

    private static int priorityOf(Character c) {
        if(Character.isUpperCase(c)) {
            return Character.toLowerCase(c) - 'a' + 1 + 26;
        } else {
            return c - 'a' + 1;
        }
    }

}
