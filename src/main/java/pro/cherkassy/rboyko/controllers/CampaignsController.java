package pro.cherkassy.rboyko.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pro.cherkassy.rboyko.enums.Status;
import pro.cherkassy.rboyko.model.Campaigns;
import pro.cherkassy.rboyko.model.Dial;
import pro.cherkassy.rboyko.model.User;
import pro.cherkassy.rboyko.service.CampaignsServiceImpl;
import pro.cherkassy.rboyko.service.interfaces.CampaignsService;
import pro.cherkassy.rboyko.service.interfaces.DiallistService;
import pro.cherkassy.rboyko.service.interfaces.UsersCampaignAssignedService;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by Sergiy on 03.04.2017.
 */

@RestController
public class CampaignsController {

    @Autowired
    private CampaignsService campaignsService;

    @Autowired
    private DiallistService diallistService;


    @RequestMapping(value = "/campaigns", method = RequestMethod.GET)
    public ResponseEntity<ArrayNode> index(){
        ObjectMapper objectMapper=new ObjectMapper();
        ArrayNode campaignsContainer=objectMapper.createArrayNode();
        List<Campaigns> campaigns = campaignsService.getAllCampaigns();
        for (Campaigns campaign:campaigns){
            ObjectNode campaignNode=objectMapper.valueToTree(campaign);
            Object[] totalExtentionAnDial=(Object[])campaignsService.getTotalExtAndDial(campaign.getId());
            campaignNode.put("totalExtensions", String.valueOf(totalExtentionAnDial[0]));
            campaignNode.put("totalDial",String.valueOf(totalExtentionAnDial[1]));
            campaignsContainer.add(campaignNode);
        }
        return new ResponseEntity<ArrayNode>(campaignsContainer, HttpStatus.OK);
    }

    @RequestMapping(value = "/campaigns/{id}", method = RequestMethod.GET)
    public ResponseEntity<ObjectNode> getCampaigns(@PathVariable int id){
        Campaigns campaigns = campaignsService.findById(id);
        List extensions=campaignsService.getExtensions(campaigns);
        ObjectMapper objectMapper=new ObjectMapper();
        //ObjectNode campaignNode=objectMapper.createObjectNode();
        ObjectNode campaignNode=objectMapper.valueToTree(campaigns);
        ArrayNode extensionsNode=objectMapper.valueToTree(extensions);
        campaignNode.putArray("assignedExt").addAll(extensionsNode);
        return new ResponseEntity<ObjectNode>(campaignNode, HttpStatus.OK);
    }

    @RequestMapping(value = "/campaigns/{id}",method = RequestMethod.DELETE)
    public ResponseEntity delete(@PathVariable int id){
        campaignsService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "/campaigns/{campaignId}/extension/{extId}")
    public ResponseEntity deleteUser(@PathVariable int campaignId,@PathVariable String extId){
        campaignsService.deleteExtension(campaignId,extId);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "/campaigns",method = RequestMethod.POST)
    public ResponseEntity add(@RequestBody Map campaing){

        Campaigns campaigns=new Campaigns();
        campaigns.setName((String)campaing.get("name"));
        campaigns.setDate_create(new Date().getTime());
        campaigns.setStatus(Status.STOP);
        List<String> extensions=(List)campaing.get("assignedExt");
        campaignsService.save(campaigns,extensions);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "/campaigns", method = RequestMethod.PUT)
    public ResponseEntity update(@RequestBody Map campaing){
        Campaigns campaigns=campaignsService.findById((int)campaing.get("id"));
        campaigns.setName((String)campaing.get("name"));
        List<String> extensions=(List)campaing.get("assignedExt");
        campaignsService.update(campaigns,extensions);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "/campaigns/{id}/status", method = RequestMethod.PUT)
    public ResponseEntity setStatus(@PathVariable int id,@RequestParam(name = "status") String paramStatus){
        Status status=Status.STOP;
        if(paramStatus.equals("START"))
            status=Status.START;
        campaignsService.setStatus(id,status);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "/campaigns/{id}/users", method = RequestMethod.GET)
    public ResponseEntity<ArrayNode> getCampaignUsers(@PathVariable int id){
        List users=campaignsService.getAssignedUsersToCampaign(id);
        ObjectMapper objectMapper=new ObjectMapper();
        ArrayNode usersConteyner=objectMapper.createArrayNode();
        for(Object user:users.toArray()){
            ObjectNode userNode=objectMapper.createObjectNode();
            Object[] userData=(Object[])user;
            userNode.put("id", String.valueOf(userData[0]));
            userNode.put("extension",(String)userData[1]);
            userNode.put("login",(String)userData[2]);
            userNode.put("email",(String)userData[3]);
            usersConteyner.add(userNode);
        }
        return new ResponseEntity<ArrayNode>(usersConteyner,HttpStatus.OK);
    }

    @RequestMapping(value="/campaigns/{campaignId}/customers",method = RequestMethod.GET)
    public ResponseEntity<List> getDialByCampaignId(@PathVariable int campaignId){
        List<Dial> dials=diallistService.getDialByCampaignId(campaignId);
        return new ResponseEntity<List>(dials,HttpStatus.OK);
    }

    @RequestMapping(value = "/campaigns/{campaignId}/customer/{customerId}",method = RequestMethod.DELETE)
    public ResponseEntity deleteCustomer(@PathVariable int campaignId,@PathVariable int customerId){
        Dial dial=diallistService.findByCustomer(customerId,campaignId);
        if(dial==null)
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        diallistService.delete(dial.getId());
        return new ResponseEntity(HttpStatus.OK);
    }
}