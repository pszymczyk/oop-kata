package com.pszymczyk.singleresponsibility;

interface CampaignsRepository {

    CampaignEntity findById(String id);

    void save(CampaignEntity campaignEntity);
}
