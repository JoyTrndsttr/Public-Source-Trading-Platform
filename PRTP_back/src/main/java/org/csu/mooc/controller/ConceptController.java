package org.csu.mooc.controller;

import org.csu.mooc.common.EntityGroup;
import org.csu.mooc.common.Relationship;
import org.csu.mooc.dao.ConceptDao;
import org.csu.mooc.pojo.*;
import org.csu.mooc.service.ConceptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/concept")
public class ConceptController {

    @Autowired
    ConceptService conceptService;

    @GetMapping("/{conceptName}")
    public CustomNode findByConceptName(@PathVariable("conceptName")String conceptName){
        Concept concept = conceptService.findByConceptName(conceptName);
        return new CustomNode(concept.getConceptName(), EntityGroup.CONCEPT.getGroup(), concept);
        //http://localhost:8329/api/concept/中断

    }

    @GetMapping("/query/{relationship}/{name}")
    public List<CustomNode> getActedByName(@PathVariable("relationship")  String rel, @PathVariable("name") String name){
        Concept concept = conceptService.findByConceptName(name);//todo:名称不存在
        List<CustomNode> customNodes = new ArrayList<>();
        System.out.println(rel+" "+name);

//        http://localhost:8329/api/concept/query/PREREQUISITE/以太网
        if (rel.equals(Relationship.PREREQUISITE.getRelation()))
        {
            Set<Concept> conceptSet = conceptService.getDependencyConcept(concept,rel);
            for(Concept concept1 : conceptSet){
                customNodes.add(new CustomNode(concept1.getConceptName(),EntityGroup.CONCEPT.getGroup(), concept1));

            }
        }
        return customNodes;

        //http://localhost:8329/api/concept/query/VEDIO/叶春泉
    }

    @GetMapping("/all")
    public List<CustomNode> findAll(){


        Iterable<Concept> conceptsIterable = conceptService.findAll();
        List<CustomNode> customNodes = new ArrayList<>();

        int i = 0;
        for(Concept concept : conceptsIterable){
            if(i++ > 10){
                break;
            }
            customNodes.add(new CustomNode(concept.getConceptName(), EntityGroup.CONCEPT.getGroup(), concept));
        }
        return customNodes;
    }//http://localhost:8329/api/concept/all




}
