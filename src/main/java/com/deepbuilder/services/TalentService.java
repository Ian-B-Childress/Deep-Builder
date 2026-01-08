package com.deepbuilder.services;

import com.deepbuilder.dto.TalentDto;
import com.deepbuilder.entities.Talent;
import com.deepbuilder.exception.DaoException;
import com.deepbuilder.repository.TalentRepository;
import com.deepbuilder.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TalentService {
    private final TalentRepository talentRepository;
    public TalentService(TalentRepository talentRepository) {
        this.talentRepository = talentRepository;
    }

    public Talent createTalent(Talent talent){
        try{
            if(talent == null){
                throw new Exception();
            }
            return talentRepository.save(talent);
        } catch (Exception e) {
            throw new DaoException("Sorry! the talent you're trying to create is not valid.");
        }
    }

    public Talent findById(Long talentId){
        try{
            if(talentId < 1){
                throw new Exception();
            }
            Optional<Talent> possibleTalent = talentRepository.findById(talentId);

            if(possibleTalent.isEmpty()){
                throw new Exception();
            }else{
                return possibleTalent.get();
            }
        } catch (Exception e) {
            throw new DaoException("Sorry! not a valid id!");
        }
    }


    public Talent updateTalent(Long talentId, Talent talent){
        Talent updatedTalent = new Talent();
        try{
            if(talentId < 1 || talent == null){
                throw new Exception();
            }
            updatedTalent = findById(talentId);
            updatedTalent.setTalentDesc(talent.getTalentDesc());
            updatedTalent.setTalentName(talent.getTalentName());

        } catch (Exception e) {
            throw new DaoException("You're trying to update a talent with incorrect data.");
        }
        return updatedTalent;
    }


    public Iterable<Talent> findAll(){
        return talentRepository.findAll();
    }

    public List<Talent> findTalentByName(String name){
        try{

        } catch (RuntimeException e) {
            throw new DaoException("No talents could be found with that name.");
        }
        return null;
    }

    //TODO find all by build stats(Build build);

}
