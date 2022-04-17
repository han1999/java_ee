package com.hanxiao.pattern;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: Han Xiao
 * @date: 2022/4/16
 **/

public class Baby {
    private List<FamilyMember> familyMembers = new ArrayList<>();

    public void add(FamilyMember familyMember) {
        familyMembers.add(familyMember);
    }

    public void cry() {
        for (FamilyMember familyMember : familyMembers) {
            familyMember.action();
        }
    }

}
