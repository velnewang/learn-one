package win.velne.learnone.shorturl.router.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import win.velne.learnone.shorturl.router.config.RouterConfig;

@RestController
public class RouterController {

    void printlnBin(int bin) {
        int length = 8;
        String binStr = Integer.toBinaryString(bin);
        String prefix = "";
        if (binStr.length() != length) {
            prefix = String.format("%0" + (length - binStr.length()) + "d", 0).replace("0", "0");
        }
        System.out.println(prefix + binStr);
    }

    @Autowired
    private RouterConfig routerConfig;

    @RequestMapping("/*")
    public void print(String[] args) {
        System.out.println(routerConfig.getListProp());
        int[][] serverList = { //
                { 0, 2, 1 }, //
                { 64, 2, 2 }, //
                { 128, 2, 3 }, //
                { 192, 2, 4 } //
        };
        int[] subnetList = new int[serverList.length];
        int[] maskList = new int[serverList.length];
        for (int i = 0; i < serverList.length; i++) {
            maskList[i] = (1 << serverList[i][1]) - 1 << 8 - serverList[i][1];
            subnetList[i] = serverList[i][0] & maskList[i];
            printlnBin(subnetList[i]);
        }

        int ip = 127;
        for (int i = 0; i < serverList.length; i++) {
            int subnet = ip & maskList[i];
            if (subnet == subnetList[i]) {
                System.out.println("server: " + serverList[i][2]);
                break;
            }
        }

    }

}
