import io.vavr.Tuple;
import io.vavr.collection.Stream;
import io.vavr.control.Option;

import java.util.*;

public class Day7NoSpceLeftOnDevice {
    public static void main(String[] args) {
        String testInput = "$ cd /\n" +
                "$ ls\n" +
                "dir a\n" +
                "14848514 b.txt\n" +
                "8504156 c.dat\n" +
                "dir d\n" +
                "$ cd a\n" +
                "$ ls\n" +
                "dir e\n" +
                "29116 f\n" +
                "2557 g\n" +
                "62596 h.lst\n" +
                "$ cd e\n" +
                "$ ls\n" +
                "584 i\n" +
                "$ cd ..\n" +
                "$ cd ..\n" +
                "$ cd d\n" +
                "$ ls\n" +
                "4060174 j\n" +
                "8033020 d.log\n" +
                "5626152 d.ext\n" +
                "7214296 k";
        Walker walker = new Walker();
        walker.findLargestDirs(testInput);


        String mainInput="$ cd /\n" +
                "$ ls\n" +
                "dir cgw\n" +
                "dir fbhz\n" +
                "dir lvrzvt\n" +
                "224312 vngq\n" +
                "dir vwlps\n" +
                "$ cd cgw\n" +
                "$ ls\n" +
                "dir jpmf\n" +
                "dir rfb\n" +
                "dir tjtccqtm\n" +
                "$ cd jpmf\n" +
                "$ ls\n" +
                "dir ncfcchsz\n" +
                "dir rfb\n" +
                "dir tjtccqtm\n" +
                "$ cd ncfcchsz\n" +
                "$ ls\n" +
                "205103 ntpprbt.pvt\n" +
                "$ cd ..\n" +
                "$ cd rfb\n" +
                "$ ls\n" +
                "331667 tjtccqtm.qzv\n" +
                "$ cd ..\n" +
                "$ cd tjtccqtm\n" +
                "$ ls\n" +
                "dir jvbb\n" +
                "175277 tpc\n" +
                "304201 vtgzj.hnb\n" +
                "69381 wnq.npz\n" +
                "dir zgpb\n" +
                "$ cd jvbb\n" +
                "$ ls\n" +
                "dir fbhz\n" +
                "$ cd fbhz\n" +
                "$ ls\n" +
                "dir wjj\n" +
                "$ cd wjj\n" +
                "$ ls\n" +
                "255580 mgft\n" +
                "$ cd ..\n" +
                "$ cd ..\n" +
                "$ cd ..\n" +
                "$ cd zgpb\n" +
                "$ ls\n" +
                "57622 bgpm.gqf\n" +
                "44482 jvbb\n" +
                "156048 tpc\n" +
                "$ cd ..\n" +
                "$ cd ..\n" +
                "$ cd ..\n" +
                "$ cd rfb\n" +
                "$ ls\n" +
                "25370 gjptbqsm.mvm\n" +
                "$ cd ..\n" +
                "$ cd tjtccqtm\n" +
                "$ ls\n" +
                "359767 pcpqw.wvn\n" +
                "9514 wplftrb\n" +
                "$ cd ..\n" +
                "$ cd ..\n" +
                "$ cd fbhz\n" +
                "$ ls\n" +
                "dir fbhz\n" +
                "328535 fbhz.fbd\n" +
                "51958 fbhz.fbp\n" +
                "37508 fcjgf.crj\n" +
                "dir llfdghs\n" +
                "dir ncfcchsz\n" +
                "222206 srvhswd.mcg\n" +
                "dir tbnq\n" +
                "62795 vtgzj.hnb\n" +
                "dir zhj\n" +
                "$ cd fbhz\n" +
                "$ ls\n" +
                "363951 psm.lsv\n" +
                "182275 sssdht.pqt\n" +
                "44558 zvntd.hvr\n" +
                "$ cd ..\n" +
                "$ cd llfdghs\n" +
                "$ ls\n" +
                "126845 flg\n" +
                "dir hsz\n" +
                "dir mlvl\n" +
                "199117 mzz.pbj\n" +
                "141875 srvhswd.mcg\n" +
                "dir tvtqs\n" +
                "309288 wrbrmh\n" +
                "$ cd hsz\n" +
                "$ ls\n" +
                "dir fbhz\n" +
                "72585 mwlqg.rfg\n" +
                "265089 ncfcchsz.cgj\n" +
                "dir qsvh\n" +
                "202721 vtgzj.hnb\n" +
                "$ cd fbhz\n" +
                "$ ls\n" +
                "163444 nsrgjtl.dts\n" +
                "$ cd ..\n" +
                "$ cd qsvh\n" +
                "$ ls\n" +
                "260300 srvhswd.mcg\n" +
                "dir tjtccqtm\n" +
                "$ cd tjtccqtm\n" +
                "$ ls\n" +
                "311932 dhcmbc.ljq\n" +
                "$ cd ..\n" +
                "$ cd ..\n" +
                "$ cd ..\n" +
                "$ cd mlvl\n" +
                "$ ls\n" +
                "55902 rfb.jnd\n" +
                "$ cd ..\n" +
                "$ cd tvtqs\n" +
                "$ ls\n" +
                "dir fbhz\n" +
                "dir hgr\n" +
                "dir njvsjmmj\n" +
                "dir tjtccqtm\n" +
                "356368 tpc\n" +
                "dir vgj\n" +
                "$ cd fbhz\n" +
                "$ ls\n" +
                "196969 ncfcchsz.tfn\n" +
                "176294 wzfchcvz.wwv\n" +
                "$ cd ..\n" +
                "$ cd hgr\n" +
                "$ ls\n" +
                "dir tjtccqtm\n" +
                "$ cd tjtccqtm\n" +
                "$ ls\n" +
                "360282 vtgzj.hnb\n" +
                "$ cd ..\n" +
                "$ cd ..\n" +
                "$ cd njvsjmmj\n" +
                "$ ls\n" +
                "dir gbrjnrh\n" +
                "$ cd gbrjnrh\n" +
                "$ ls\n" +
                "270925 psm.lsv\n" +
                "$ cd ..\n" +
                "$ cd ..\n" +
                "$ cd tjtccqtm\n" +
                "$ ls\n" +
                "dir nlqt\n" +
                "dir tjtccqtm\n" +
                "47866 vtgzj.hnb\n" +
                "144250 zdg.brf\n" +
                "$ cd nlqt\n" +
                "$ ls\n" +
                "49935 tpc\n" +
                "$ cd ..\n" +
                "$ cd tjtccqtm\n" +
                "$ ls\n" +
                "178987 sgpdvcf\n" +
                "$ cd ..\n" +
                "$ cd ..\n" +
                "$ cd vgj\n" +
                "$ ls\n" +
                "213820 mcbph.srq\n" +
                "$ cd ..\n" +
                "$ cd ..\n" +
                "$ cd ..\n" +
                "$ cd ncfcchsz\n" +
                "$ ls\n" +
                "267915 fbhz\n" +
                "dir tjtccqtm\n" +
                "205385 zghlv.mtv\n" +
                "$ cd tjtccqtm\n" +
                "$ ls\n" +
                "334824 ptbdgpn.wnz\n" +
                "$ cd ..\n" +
                "$ cd ..\n" +
                "$ cd tbnq\n" +
                "$ ls\n" +
                "138692 dzwgs\n" +
                "70126 gjps.vbz\n" +
                "dir jvbb\n" +
                "dir nzl\n" +
                "196653 rsshtl.qlg\n" +
                "110016 srvhswd.mcg\n" +
                "217737 vngq\n" +
                "$ cd jvbb\n" +
                "$ ls\n" +
                "dir wshhs\n" +
                "dir ztrb\n" +
                "$ cd wshhs\n" +
                "$ ls\n" +
                "dir bpcv\n" +
                "285906 ntptv.hld\n" +
                "182940 rfb.wfd\n" +
                "24187 wgfmq\n" +
                "$ cd bpcv\n" +
                "$ ls\n" +
                "108995 ncfcchsz.rmg\n" +
                "304028 srvhswd.mcg\n" +
                "$ cd ..\n" +
                "$ cd ..\n" +
                "$ cd ztrb\n" +
                "$ ls\n" +
                "88425 pfzbdqmw\n" +
                "$ cd ..\n" +
                "$ cd ..\n" +
                "$ cd nzl\n" +
                "$ ls\n" +
                "dir fbhz\n" +
                "dir jzvvr\n" +
                "dir mghww\n" +
                "131115 qcpdd.jfb\n" +
                "208300 rqhtgdf.rqf\n" +
                "dir tnfg\n" +
                "$ cd fbhz\n" +
                "$ ls\n" +
                "317958 fbhz.pws\n" +
                "$ cd ..\n" +
                "$ cd jzvvr\n" +
                "$ ls\n" +
                "292945 dnqfmf.cwg\n" +
                "8055 mwtrbv.sfm\n" +
                "119001 rfb\n" +
                "dir srgrvcm\n" +
                "214676 srvhswd.mcg\n" +
                "$ cd srgrvcm\n" +
                "$ ls\n" +
                "dir cfwmvbjq\n" +
                "dir dqwwtrr\n" +
                "102903 grhqhm.bhm\n" +
                "360122 qmgtr.qmn\n" +
                "dir tjtccqtm\n" +
                "$ cd cfwmvbjq\n" +
                "$ ls\n" +
                "91385 vtgzj.hnb\n" +
                "$ cd ..\n" +
                "$ cd dqwwtrr\n" +
                "$ ls\n" +
                "151683 htg.ncm\n" +
                "178927 vngq\n" +
                "236079 vtgzj.hnb\n" +
                "$ cd ..\n" +
                "$ cd tjtccqtm\n" +
                "$ ls\n" +
                "334582 psm.lsv\n" +
                "$ cd ..\n" +
                "$ cd ..\n" +
                "$ cd ..\n" +
                "$ cd mghww\n" +
                "$ ls\n" +
                "48114 msvbqh\n" +
                "$ cd ..\n" +
                "$ cd tnfg\n" +
                "$ ls\n" +
                "172920 jhn.ghz\n" +
                "$ cd ..\n" +
                "$ cd ..\n" +
                "$ cd ..\n" +
                "$ cd zhj\n" +
                "$ ls\n" +
                "dir dqzgfcd\n" +
                "dir jvbb\n" +
                "dir ncnhjjs\n" +
                "$ cd dqzgfcd\n" +
                "$ ls\n" +
                "dir ppmbn\n" +
                "dir rfb\n" +
                "dir srlvzvr\n" +
                "225107 srvhswd.mcg\n" +
                "353094 vngq\n" +
                "dir vtdvdgdv\n" +
                "297817 vtgzj.hnb\n" +
                "dir vwhnlp\n" +
                "dir wsmvrf\n" +
                "$ cd ppmbn\n" +
                "$ ls\n" +
                "6037 vngq\n" +
                "$ cd ..\n" +
                "$ cd rfb\n" +
                "$ ls\n" +
                "293304 nzhchfrv.nst\n" +
                "194726 rfb.gfs\n" +
                "287537 tpc\n" +
                "137637 vtgzj.hnb\n" +
                "dir wdm\n" +
                "$ cd wdm\n" +
                "$ ls\n" +
                "61473 psm.lsv\n" +
                "152521 srvhswd.mcg\n" +
                "$ cd ..\n" +
                "$ cd ..\n" +
                "$ cd srlvzvr\n" +
                "$ ls\n" +
                "dir dlp\n" +
                "274123 whc.cjc\n" +
                "$ cd dlp\n" +
                "$ ls\n" +
                "dir rfpgt\n" +
                "$ cd rfpgt\n" +
                "$ ls\n" +
                "281038 jvbb.mnq\n" +
                "312481 mmjcgss\n" +
                "186883 vdpq.qzn\n" +
                "194336 wvjrhdq.llv\n" +
                "$ cd ..\n" +
                "$ cd ..\n" +
                "$ cd ..\n" +
                "$ cd vtdvdgdv\n" +
                "$ ls\n" +
                "dir rfb\n" +
                "dir tjtccqtm\n" +
                "$ cd rfb\n" +
                "$ ls\n" +
                "196456 dprdjqnp.wqc\n" +
                "67720 psm.lsv\n" +
                "820 rfb.jrh\n" +
                "170351 tpc\n" +
                "$ cd ..\n" +
                "$ cd tjtccqtm\n" +
                "$ ls\n" +
                "269007 bsrvltnf\n" +
                "$ cd ..\n" +
                "$ cd ..\n" +
                "$ cd vwhnlp\n" +
                "$ ls\n" +
                "dir fbhz\n" +
                "30697 ncfcchsz.dlh\n" +
                "dir rfb\n" +
                "dir tjtccqtm\n" +
                "185165 vtgzj.hnb\n" +
                "$ cd fbhz\n" +
                "$ ls\n" +
                "dir dstmnnd\n" +
                "65237 dvhhwv.zqz\n" +
                "156937 gtbzgp\n" +
                "dir jvbb\n" +
                "dir ncfcchsz\n" +
                "dir wdpqfl\n" +
                "$ cd dstmnnd\n" +
                "$ ls\n" +
                "334642 grbvbw\n" +
                "dir jvbb\n" +
                "$ cd jvbb\n" +
                "$ ls\n" +
                "187235 bgrhrn.wmt\n" +
                "$ cd ..\n" +
                "$ cd ..\n" +
                "$ cd jvbb\n" +
                "$ ls\n" +
                "dir dcszm\n" +
                "280304 fbhz.bfq\n" +
                "161981 jrgqlf\n" +
                "dir mvcfwwlm\n" +
                "194182 psm.lsv\n" +
                "dir rfb\n" +
                "40787 zrscw\n" +
                "$ cd dcszm\n" +
                "$ ls\n" +
                "178161 gfc.nss\n" +
                "$ cd ..\n" +
                "$ cd mvcfwwlm\n" +
                "$ ls\n" +
                "284005 hvzzlc\n" +
                "$ cd ..\n" +
                "$ cd rfb\n" +
                "$ ls\n" +
                "295068 fbhz.ccj\n" +
                "dir jvbb\n" +
                "73713 mqs\n" +
                "dir ncfcchsz\n" +
                "99417 psps.pnc\n" +
                "dir rhmmtvv\n" +
                "$ cd jvbb\n" +
                "$ ls\n" +
                "62151 hlblqv.cbq\n" +
                "318565 jvbb.rgv\n" +
                "230913 ppq.chd\n" +
                "$ cd ..\n" +
                "$ cd ncfcchsz\n" +
                "$ ls\n" +
                "133380 srvhswd.mcg\n" +
                "$ cd ..\n" +
                "$ cd rhmmtvv\n" +
                "$ ls\n" +
                "270217 qms.zrf\n" +
                "$ cd ..\n" +
                "$ cd ..\n" +
                "$ cd ..\n" +
                "$ cd ncfcchsz\n" +
                "$ ls\n" +
                "dir bzpz\n" +
                "dir fmhdlm\n" +
                "dir wqctddqc\n" +
                "$ cd bzpz\n" +
                "$ ls\n" +
                "270136 tpc\n" +
                "271633 vtgzj.hnb\n" +
                "$ cd ..\n" +
                "$ cd fmhdlm\n" +
                "$ ls\n" +
                "273720 mgf.pdm\n" +
                "23453 rfb.lvs\n" +
                "49685 tld.vbh\n" +
                "$ cd ..\n" +
                "$ cd wqctddqc\n" +
                "$ ls\n" +
                "dir ncfcchsz\n" +
                "$ cd ncfcchsz\n" +
                "$ ls\n" +
                "111237 vqvs\n" +
                "$ cd ..\n" +
                "$ cd ..\n" +
                "$ cd ..\n" +
                "$ cd wdpqfl\n" +
                "$ ls\n" +
                "dir fmrclsn\n" +
                "258435 fzgtz.bhg\n" +
                "dir mwwmbpgr\n" +
                "dir nsf\n" +
                "dir tfpqqjw\n" +
                "118118 tjtccqtm\n" +
                "219688 tjtccqtm.tst\n" +
                "$ cd fmrclsn\n" +
                "$ ls\n" +
                "271116 gzbqm.tnj\n" +
                "216909 jvbb\n" +
                "167454 qnfdzw.slr\n" +
                "252140 tsrzcnjb\n" +
                "$ cd ..\n" +
                "$ cd mwwmbpgr\n" +
                "$ ls\n" +
                "dir jvbb\n" +
                "dir rqfqbw\n" +
                "$ cd jvbb\n" +
                "$ ls\n" +
                "44631 tjtccqtm\n" +
                "$ cd ..\n" +
                "$ cd rqfqbw\n" +
                "$ ls\n" +
                "dir cqpwhrtp\n" +
                "$ cd cqpwhrtp\n" +
                "$ ls\n" +
                "305787 vjndql.qqv\n" +
                "$ cd ..\n" +
                "$ cd ..\n" +
                "$ cd ..\n" +
                "$ cd nsf\n" +
                "$ ls\n" +
                "211811 ggztzqp\n" +
                "69628 vtgzj.hnb\n" +
                "$ cd ..\n" +
                "$ cd tfpqqjw\n" +
                "$ ls\n" +
                "295011 ncfcchsz.dnn\n" +
                "88554 psm.lsv\n" +
                "$ cd ..\n" +
                "$ cd ..\n" +
                "$ cd ..\n" +
                "$ cd rfb\n" +
                "$ ls\n" +
                "51633 ncfcchsz\n" +
                "318667 psm.lsv\n" +
                "49231 qnsldrn\n" +
                "240239 sdcmgc.gdt\n" +
                "dir tgcr\n" +
                "121575 vtgzj.hnb\n" +
                "$ cd tgcr\n" +
                "$ ls\n" +
                "198742 rfb.nsl\n" +
                "$ cd ..\n" +
                "$ cd ..\n" +
                "$ cd tjtccqtm\n" +
                "$ ls\n" +
                "dir vnwpw\n" +
                "$ cd vnwpw\n" +
                "$ ls\n" +
                "338543 htwmhv\n" +
                "18782 lvwjtn.dcz\n" +
                "212005 ncfcchsz\n" +
                "dir rfb\n" +
                "dir tjhvvl\n" +
                "95069 vtgzj.hnb\n" +
                "117084 wsfvhn\n" +
                "$ cd rfb\n" +
                "$ ls\n" +
                "89621 fbhz.vnm\n" +
                "$ cd ..\n" +
                "$ cd tjhvvl\n" +
                "$ ls\n" +
                "262643 clmfhnct.wrt\n" +
                "dir fbhz\n" +
                "101520 ncfcchsz\n" +
                "169089 vtf.bmc\n" +
                "72983 zgjw.wpn\n" +
                "74431 zlwvcwn.gzf\n" +
                "$ cd fbhz\n" +
                "$ ls\n" +
                "213519 zpvhg\n" +
                "$ cd ..\n" +
                "$ cd ..\n" +
                "$ cd ..\n" +
                "$ cd ..\n" +
                "$ cd ..\n" +
                "$ cd wsmvrf\n" +
                "$ ls\n" +
                "dir ccbw\n" +
                "dir nqjpdlc\n" +
                "253007 rfb\n" +
                "dir sjgjgwb\n" +
                "dir zprqg\n" +
                "$ cd ccbw\n" +
                "$ ls\n" +
                "dir crjsgdv\n" +
                "dir dthrqpvv\n" +
                "dir ncfcchsz\n" +
                "dir ppqhd\n" +
                "dir tjtccqtm\n" +
                "dir ztsmqn\n" +
                "$ cd crjsgdv\n" +
                "$ ls\n" +
                "dir jgstsj\n" +
                "169620 vngq\n" +
                "$ cd jgstsj\n" +
                "$ ls\n" +
                "251288 vtgzj.hnb\n" +
                "$ cd ..\n" +
                "$ cd ..\n" +
                "$ cd dthrqpvv\n" +
                "$ ls\n" +
                "234510 fldrtqh.cbq\n" +
                "$ cd ..\n" +
                "$ cd ncfcchsz\n" +
                "$ ls\n" +
                "177247 dbt.fsb\n" +
                "$ cd ..\n" +
                "$ cd ppqhd\n" +
                "$ ls\n" +
                "21458 psm.lsv\n" +
                "20155 tjtccqtm.rsn\n" +
                "$ cd ..\n" +
                "$ cd tjtccqtm\n" +
                "$ ls\n" +
                "71907 psm.lsv\n" +
                "$ cd ..\n" +
                "$ cd ztsmqn\n" +
                "$ ls\n" +
                "124096 gjzgbrj.sjn\n" +
                "$ cd ..\n" +
                "$ cd ..\n" +
                "$ cd nqjpdlc\n" +
                "$ ls\n" +
                "dir jvbb\n" +
                "dir ltwl\n" +
                "143570 lwcgls.qvp\n" +
                "$ cd jvbb\n" +
                "$ ls\n" +
                "266605 qvwfhw.qvh\n" +
                "$ cd ..\n" +
                "$ cd ltwl\n" +
                "$ ls\n" +
                "dir lrgjbbn\n" +
                "$ cd lrgjbbn\n" +
                "$ ls\n" +
                "68291 tjtccqtm.rlr\n" +
                "$ cd ..\n" +
                "$ cd ..\n" +
                "$ cd ..\n" +
                "$ cd sjgjgwb\n" +
                "$ ls\n" +
                "265194 ddv\n" +
                "dir ghqtfhcz\n" +
                "dir jwzmtqff\n" +
                "15930 mzgtdwsg\n" +
                "$ cd ghqtfhcz\n" +
                "$ ls\n" +
                "dir gtlfvjpg\n" +
                "$ cd gtlfvjpg\n" +
                "$ ls\n" +
                "dir vwz\n" +
                "$ cd vwz\n" +
                "$ ls\n" +
                "252002 tpc\n" +
                "$ cd ..\n" +
                "$ cd ..\n" +
                "$ cd ..\n" +
                "$ cd jwzmtqff\n" +
                "$ ls\n" +
                "238465 gsr.mrj\n" +
                "332865 gzfcfqn.lbd\n" +
                "$ cd ..\n" +
                "$ cd ..\n" +
                "$ cd zprqg\n" +
                "$ ls\n" +
                "148532 nzjwc\n" +
                "179858 plznjhb\n" +
                "70176 tpc\n" +
                "$ cd ..\n" +
                "$ cd ..\n" +
                "$ cd ..\n" +
                "$ cd jvbb\n" +
                "$ ls\n" +
                "dir bnllsz\n" +
                "dir cqdr\n" +
                "293380 hrszhbzc.rrq\n" +
                "253762 jvbb\n" +
                "dir jwn\n" +
                "251152 lchdqwvg\n" +
                "dir lrh\n" +
                "dir nfbhj\n" +
                "dir nnflrw\n" +
                "dir rfb\n" +
                "293144 srvhswd.mcg\n" +
                "104936 vtgzj.hnb\n" +
                "$ cd bnllsz\n" +
                "$ ls\n" +
                "216397 vngq\n" +
                "$ cd ..\n" +
                "$ cd cqdr\n" +
                "$ ls\n" +
                "272746 psm.lsv\n" +
                "81840 tpc\n" +
                "$ cd ..\n" +
                "$ cd jwn\n" +
                "$ ls\n" +
                "224049 fhl.mrh\n" +
                "342246 tpc\n" +
                "233666 zmbg\n" +
                "$ cd ..\n" +
                "$ cd lrh\n" +
                "$ ls\n" +
                "139676 mcdv\n" +
                "$ cd ..\n" +
                "$ cd nfbhj\n" +
                "$ ls\n" +
                "49779 rfb.tnm\n" +
                "$ cd ..\n" +
                "$ cd nnflrw\n" +
                "$ ls\n" +
                "56516 hgtjdb\n" +
                "79167 psm.lsv\n" +
                "$ cd ..\n" +
                "$ cd rfb\n" +
                "$ ls\n" +
                "65765 mcdv\n" +
                "$ cd ..\n" +
                "$ cd ..\n" +
                "$ cd ncnhjjs\n" +
                "$ ls\n" +
                "dir jvbb\n" +
                "276470 ncfcchsz\n" +
                "273860 vngq\n" +
                "$ cd jvbb\n" +
                "$ ls\n" +
                "9420 psmrjhmp.dfj\n" +
                "$ cd ..\n" +
                "$ cd ..\n" +
                "$ cd ..\n" +
                "$ cd ..\n" +
                "$ cd lvrzvt\n" +
                "$ ls\n" +
                "26201 ncfcchsz.zrn\n" +
                "267647 ncppww\n" +
                "dir qzddwnm\n" +
                "345874 tpc\n" +
                "115177 vtgzj.hnb\n" +
                "dir zzwqlz\n" +
                "$ cd qzddwnm\n" +
                "$ ls\n" +
                "214814 psm.lsv\n" +
                "$ cd ..\n" +
                "$ cd zzwqlz\n" +
                "$ ls\n" +
                "181990 pcz.ctb\n" +
                "258280 tjtccqtm\n" +
                "37664 vtgzj.hnb\n" +
                "$ cd ..\n" +
                "$ cd ..\n" +
                "$ cd vwlps\n" +
                "$ ls\n" +
                "dir fbhz\n" +
                "dir jvbb\n" +
                "347635 psm.lsv\n" +
                "101891 pzzt.prc\n" +
                "dir rfb\n" +
                "dir tjtccqtm\n" +
                "322963 tjtccqtm.swf\n" +
                "$ cd fbhz\n" +
                "$ ls\n" +
                "dir fbhz\n" +
                "$ cd fbhz\n" +
                "$ ls\n" +
                "dir mnnzbnl\n" +
                "115 zhgrzjt.hlq\n" +
                "$ cd mnnzbnl\n" +
                "$ ls\n" +
                "624 vngq\n" +
                "$ cd ..\n" +
                "$ cd ..\n" +
                "$ cd ..\n" +
                "$ cd jvbb\n" +
                "$ ls\n" +
                "149547 jtng.qfh\n" +
                "84714 wqqnqpc.crj\n" +
                "$ cd ..\n" +
                "$ cd rfb\n" +
                "$ ls\n" +
                "dir ddcjgrdb\n" +
                "26416 jvbb.nbg\n" +
                "dir lwjvv\n" +
                "dir mtzbmlnp\n" +
                "dir nsq\n" +
                "42884 pmzdjzmv\n" +
                "305628 sgc\n" +
                "109079 srvhswd.mcg\n" +
                "303802 tpc\n" +
                "$ cd ddcjgrdb\n" +
                "$ ls\n" +
                "dir jvbb\n" +
                "dir rfb\n" +
                "$ cd jvbb\n" +
                "$ ls\n" +
                "348073 jgwzvs\n" +
                "$ cd ..\n" +
                "$ cd rfb\n" +
                "$ ls\n" +
                "dir tjtccqtm\n" +
                "119113 tpc\n" +
                "$ cd tjtccqtm\n" +
                "$ ls\n" +
                "357579 rfb\n" +
                "124868 srvhswd.mcg\n" +
                "$ cd ..\n" +
                "$ cd ..\n" +
                "$ cd ..\n" +
                "$ cd lwjvv\n" +
                "$ ls\n" +
                "212416 fbglfwjn\n" +
                "dir hhjlvjds\n" +
                "158555 tpc\n" +
                "dir tvqng\n" +
                "287589 vngq\n" +
                "dir zcn\n" +
                "$ cd hhjlvjds\n" +
                "$ ls\n" +
                "57297 przml.gfn\n" +
                "173735 psm.lsv\n" +
                "245882 srvhswd.mcg\n" +
                "244645 tjtccqtm.gnh\n" +
                "289149 vngq\n" +
                "dir zmzj\n" +
                "$ cd zmzj\n" +
                "$ ls\n" +
                "28824 vngq\n" +
                "$ cd ..\n" +
                "$ cd ..\n" +
                "$ cd tvqng\n" +
                "$ ls\n" +
                "136988 fbhz.wnl\n" +
                "$ cd ..\n" +
                "$ cd zcn\n" +
                "$ ls\n" +
                "dir czczrddv\n" +
                "$ cd czczrddv\n" +
                "$ ls\n" +
                "239586 zjwswstd.mdj\n" +
                "$ cd ..\n" +
                "$ cd ..\n" +
                "$ cd ..\n" +
                "$ cd mtzbmlnp\n" +
                "$ ls\n" +
                "dir fbhz\n" +
                "dir jvbb\n" +
                "231169 mnrbmhvt\n" +
                "dir nhfsqbb\n" +
                "dir sjmm\n" +
                "dir ttsjtcc\n" +
                "$ cd fbhz\n" +
                "$ ls\n" +
                "dir lhtc\n" +
                "dir tjtccqtm\n" +
                "9513 vtgzj.hnb\n" +
                "$ cd lhtc\n" +
                "$ ls\n" +
                "100051 fbhz.cvg\n" +
                "$ cd ..\n" +
                "$ cd tjtccqtm\n" +
                "$ ls\n" +
                "193182 psm.lsv\n" +
                "$ cd ..\n" +
                "$ cd ..\n" +
                "$ cd jvbb\n" +
                "$ ls\n" +
                "224879 hvswfzqc.zmc\n" +
                "dir rfb\n" +
                "202937 rflsltm.bcc\n" +
                "dir tjtccqtm\n" +
                "$ cd rfb\n" +
                "$ ls\n" +
                "238032 fbhz\n" +
                "dir fgctrfr\n" +
                "306802 jvbb\n" +
                "225954 ncfcchsz.lcs\n" +
                "dir tjtccqtm\n" +
                "$ cd fgctrfr\n" +
                "$ ls\n" +
                "dir dqjrndw\n" +
                "103974 jmmjds\n" +
                "233363 mqr.zhm\n" +
                "334730 psm.lsv\n" +
                "dir rbbw\n" +
                "281420 tjtccqtm\n" +
                "dir zgrrdb\n" +
                "$ cd dqjrndw\n" +
                "$ ls\n" +
                "295822 tpc\n" +
                "$ cd ..\n" +
                "$ cd rbbw\n" +
                "$ ls\n" +
                "dir hrwj\n" +
                "$ cd hrwj\n" +
                "$ ls\n" +
                "dir zlhhnwrv\n" +
                "$ cd zlhhnwrv\n" +
                "$ ls\n" +
                "168370 tjtccqtm.dnn\n" +
                "$ cd ..\n" +
                "$ cd ..\n" +
                "$ cd ..\n" +
                "$ cd zgrrdb\n" +
                "$ ls\n" +
                "84053 vtgzj.hnb\n" +
                "$ cd ..\n" +
                "$ cd ..\n" +
                "$ cd tjtccqtm\n" +
                "$ ls\n" +
                "297111 jpnzcw.srg\n" +
                "$ cd ..\n" +
                "$ cd ..\n" +
                "$ cd tjtccqtm\n" +
                "$ ls\n" +
                "dir jfmc\n" +
                "dir qwrd\n" +
                "dir tjtccqtm\n" +
                "$ cd jfmc\n" +
                "$ ls\n" +
                "dir fbhz\n" +
                "dir fjqnrb\n" +
                "dir mpc\n" +
                "dir ncfcchsz\n" +
                "139767 vtgzj.hnb\n" +
                "$ cd fbhz\n" +
                "$ ls\n" +
                "dir rfb\n" +
                "dir tqmtbvb\n" +
                "$ cd rfb\n" +
                "$ ls\n" +
                "304548 jhrjt\n" +
                "$ cd ..\n" +
                "$ cd tqmtbvb\n" +
                "$ ls\n" +
                "62368 vngq\n" +
                "$ cd ..\n" +
                "$ cd ..\n" +
                "$ cd fjqnrb\n" +
                "$ ls\n" +
                "dir qdrmjmds\n" +
                "dir rfb\n" +
                "dir sdtdrmz\n" +
                "$ cd qdrmjmds\n" +
                "$ ls\n" +
                "dir qscgv\n" +
                "dir rfb\n" +
                "$ cd qscgv\n" +
                "$ ls\n" +
                "173814 ncfcchsz.nch\n" +
                "$ cd ..\n" +
                "$ cd rfb\n" +
                "$ ls\n" +
                "1592 vtgzj.hnb\n" +
                "$ cd ..\n" +
                "$ cd ..\n" +
                "$ cd rfb\n" +
                "$ ls\n" +
                "237598 dvbnmp.bcw\n" +
                "$ cd ..\n" +
                "$ cd sdtdrmz\n" +
                "$ ls\n" +
                "43253 sqdd\n" +
                "$ cd ..\n" +
                "$ cd ..\n" +
                "$ cd mpc\n" +
                "$ ls\n" +
                "dir bdsnl\n" +
                "$ cd bdsnl\n" +
                "$ ls\n" +
                "175855 psm.lsv\n" +
                "$ cd ..\n" +
                "$ cd ..\n" +
                "$ cd ncfcchsz\n" +
                "$ ls\n" +
                "dir ctqnwzgn\n" +
                "dir dddjjbrs\n" +
                "dir nbnn\n" +
                "dir tjtccqtm\n" +
                "$ cd ctqnwzgn\n" +
                "$ ls\n" +
                "211637 ncfcchsz\n" +
                "$ cd ..\n" +
                "$ cd dddjjbrs\n" +
                "$ ls\n" +
                "160464 bjbdh.mtr\n" +
                "139283 jjgblbjc.bvn\n" +
                "dir lqpsr\n" +
                "155029 szcpzjz.vtv\n" +
                "$ cd lqpsr\n" +
                "$ ls\n" +
                "314159 mdzgl.jqd\n" +
                "$ cd ..\n" +
                "$ cd ..\n" +
                "$ cd nbnn\n" +
                "$ ls\n" +
                "218457 tpc\n" +
                "$ cd ..\n" +
                "$ cd tjtccqtm\n" +
                "$ ls\n" +
                "dir rfb\n" +
                "109587 tfw\n" +
                "dir vqsjdd\n" +
                "$ cd rfb\n" +
                "$ ls\n" +
                "240479 rblwfbn\n" +
                "$ cd ..\n" +
                "$ cd vqsjdd\n" +
                "$ ls\n" +
                "253970 srvhswd.mcg\n" +
                "$ cd ..\n" +
                "$ cd ..\n" +
                "$ cd ..\n" +
                "$ cd ..\n" +
                "$ cd qwrd\n" +
                "$ ls\n" +
                "dir dgf\n" +
                "$ cd dgf\n" +
                "$ ls\n" +
                "340237 fbsfq.mls\n" +
                "dir tjtccqtm\n" +
                "dir ttqnbdjn\n" +
                "$ cd tjtccqtm\n" +
                "$ ls\n" +
                "dir msgtcp\n" +
                "$ cd msgtcp\n" +
                "$ ls\n" +
                "245596 fbhz\n" +
                "$ cd ..\n" +
                "$ cd ..\n" +
                "$ cd ttqnbdjn\n" +
                "$ ls\n" +
                "dir gvll\n" +
                "$ cd gvll\n" +
                "$ ls\n" +
                "dir bhhzh\n" +
                "$ cd bhhzh\n" +
                "$ ls\n" +
                "153339 wcqpmnb.slt\n" +
                "$ cd ..\n" +
                "$ cd ..\n" +
                "$ cd ..\n" +
                "$ cd ..\n" +
                "$ cd ..\n" +
                "$ cd tjtccqtm\n" +
                "$ ls\n" +
                "dir nzbzjpnl\n" +
                "$ cd nzbzjpnl\n" +
                "$ ls\n" +
                "72123 dzpjf.wmb\n" +
                "35136 ncfcchsz.qnz\n" +
                "234519 vhq.vrr\n" +
                "$ cd ..\n" +
                "$ cd ..\n" +
                "$ cd ..\n" +
                "$ cd ..\n" +
                "$ cd nhfsqbb\n" +
                "$ ls\n" +
                "109518 tqnct.jvf\n" +
                "51666 vngq\n" +
                "$ cd ..\n" +
                "$ cd sjmm\n" +
                "$ ls\n" +
                "263022 psm.lsv\n" +
                "dir qrpr\n" +
                "dir rfb\n" +
                "$ cd qrpr\n" +
                "$ ls\n" +
                "51657 tpc\n" +
                "$ cd ..\n" +
                "$ cd rfb\n" +
                "$ ls\n" +
                "185213 fllcngdc\n" +
                "$ cd ..\n" +
                "$ cd ..\n" +
                "$ cd ttsjtcc\n" +
                "$ ls\n" +
                "dir fbhz\n" +
                "dir tjbnz\n" +
                "$ cd fbhz\n" +
                "$ ls\n" +
                "112216 slzn.jls\n" +
                "$ cd ..\n" +
                "$ cd tjbnz\n" +
                "$ ls\n" +
                "73261 fbhz.wtd\n" +
                "$ cd ..\n" +
                "$ cd ..\n" +
                "$ cd ..\n" +
                "$ cd nsq\n" +
                "$ ls\n" +
                "93689 srvhswd.mcg\n" +
                "$ cd ..\n" +
                "$ cd ..\n" +
                "$ cd tjtccqtm\n" +
                "$ ls\n" +
                "232421 vngq\n";
        new Walker().findLargestDirs(mainInput);

    }


    static final class Walker {
        private Dir root;
        private Dir currentDir;

        Walker(Dir root, Dir currentDir) {
            this.root = root;
            this.currentDir = currentDir;
        }

        Walker() {
            this(new Dir("/"));
        }

        Walker(Dir root) {
            this(root, root);
        }


        private void findLargestDirs(String input) {
            Stream<String> inputCommands = Stream.ofAll(input.lines());
            processCommands(inputCommands);

            io.vavr.collection.HashMap<String, Integer> dirSizes = root.dirSizes();
            io.vavr.collection.HashMap<String, Integer> smallDirs = dirSizes.filterValues(f -> f <= 100000);

            System.out.println("small Dirs Sum:" + smallDirs.values().sum());

            int rootSize = root.size();
            int availableSpaceRequired = 70000000 - rootSize;
            int requiredSpace = 30000000 - availableSpaceRequired;
            System.out.println("Root size: " + rootSize);
            System.out.println("required to free up:" + requiredSpace);

            Integer dirToDelete = dirSizes.values()
                    .sorted()
                    .dropWhile(i -> i < requiredSpace)
                    .head();

            System.out.println(dirToDelete);

        }

        private void processCommands(Stream<String> inputCommands) {
            for (String cmd : inputCommands) {
                switch (cmd.substring(0, 4)) {
                    case "$ cd":
                        currentDir = navigateToDir(cmd.substring(5));
                        break;
                    case "$ ls":
                        break;
                    default:
                        if (cmd.startsWith("dir")) {
                            currentDir.addDir(cmd.substring(4));
                        } else {
                            String[] s = cmd.split(" ");
                            currentDir.addFile(s[1], Integer.parseInt(s[0]));
                        }

                }
            }
        }

        private Dir navigateToDir(String dirName) {
            return switch (dirName) {
                case ".." -> currentDir.parent.get();
                case "/" -> root;
                default -> currentDir.navigateTo(dirName);
            };
        }
    }

    record File(int size) {
    }

    record Dir(String name, Option<Dir> parent, Map<String, Dir> dirs, Map<String, File> files) {

        public Dir(String name) {
            this(name, Option.none(), new TreeMap<>(), new TreeMap<>());
        }

        public Dir(String name, Dir parent) {
            this(name, Option.some(parent), new TreeMap<>(), new TreeMap<>());
        }

        public Dir navigateTo(String dirName) {
            return dirs.computeIfAbsent(dirName, (x) -> new Dir(x,this));
        }

        public void addDir(String dirName) {
            dirs.computeIfAbsent(dirName, (x) -> new Dir(x, this));
        }

        public void addFile(String fileName, int size) {
            files.put(fileName, new File(size));
        }

        public int size() {
            return Stream.ofAll(dirs.values()).map(Dir::size).sum().intValue()
                    + Stream.ofAll(files.values()).map(File::size).sum().intValue();
        }

        public io.vavr.collection.HashMap<String, Integer> dirSizes() {

            io.vavr.collection.HashMap<String, Integer> map = io.vavr.collection.HashMap.ofAll(dirs).values()
                    .map(Dir::dirSizes)
                    .foldLeft(io.vavr.collection.HashMap.empty(), ((l, r) -> l.merge(r)));

            String path = path();
            return io.vavr.collection.HashMap.ofAll(dirs)
                    .map((dirName, dir) -> Tuple.of(path + dirName,dir.size()))
                    .merge(map)
                   ;
        }

        private String path() {
            return parent.map(p -> p.path() + name + "/").getOrElse(name);
        }

        @Override
        public String toString() {
            return "Dir{" +
                    "dirs=" + dirs +
                    ", files=" + files +
                    '}';
        }
    }
}
