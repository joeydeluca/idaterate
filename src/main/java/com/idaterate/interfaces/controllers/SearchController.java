package com.idaterate.interfaces.controllers;

import com.idaterate.domain.DateRate.DateRate;
import com.idaterate.domain.valueobejcts.DatingSite;
import com.idaterate.domain.valueobejcts.SortingOption;
import com.idaterate.interfaces.dtos.DateRateDisplayItemDTO;
import com.idaterate.interfaces.dtos.SearchCriteriaDTO;
import com.idaterate.service.DateRateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Joe Deluca on 06/10/2015.
 */
@Controller
@RequestMapping("/search")
public class SearchController extends BaseController {

    @Autowired
    private DateRateService service;

    @RequestMapping(method = RequestMethod.GET)
    public String search(@ModelAttribute("SearchCriteriaDTO") SearchCriteriaDTO searchCriteriaDTO, Model model) {
        model.addAttribute("dateRateDTO", searchCriteriaDTO);
        List<DateRateDisplayItemDTO> dateRateList = new ArrayList<>();
        SortingOption sortingOption = SortingOption.getEnumFromId(searchCriteriaDTO.getSortingOption());
        Page<DateRate> dateRates =
                service.search(searchCriteriaDTO.getUsername(),
                        searchCriteriaDTO.getSelectedDatingSite(),
                        searchCriteriaDTO.getHashtags(),
                        searchCriteriaDTO.getCity(),
                        sortingOption,
                        searchCriteriaDTO.getPage());

        for (DateRate dateRate : dateRates.getContent()) {
            dateRateList.add(DateRateDisplayItemDTO.build(dateRate));
        }

        model.addAttribute("dateRateList", dateRateList);
        model.addAttribute("datingSiteOptions", DatingSite.getValues(true));
        model.addAttribute("sortingOptionDisplay", sortingOption.getDisplay());

        if(dateRates.hasPrevious()) {
            model.addAttribute("previousPageNumber", dateRates.previousPageable().getPageNumber());
        }
        if(dateRates.hasNext()) {
            model.addAttribute("nextPageNumber", dateRates.nextPageable().getPageNumber());
        }

        model.addAttribute("totalPages", dateRates.getTotalPages());
        model.addAttribute("currentPage", searchCriteriaDTO.getPage());

        return "search";
    }

}
