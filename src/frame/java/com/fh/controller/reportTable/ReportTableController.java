package com.fh.controller.reportTable;

import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fh.controller.base.BaseController;
import com.fh.service.reportTable.ReportTableService;
import com.fh.util.ExportUtils;
import com.fh.util.GridDataInfo;
import com.fh.util.MethodInvoke;
import com.fh.util.PageUtils;


@Controller
@RequestMapping(value="/report")
public class ReportTableController extends BaseController {
	
	@Resource(name="reportTableService")
	private ReportTableService reportTableService;	
	


	@RequestMapping(value = "/sysUser")
	@ResponseBody
	public GridDataInfo registerReport(String page, String rows,
			String sord, String sortname,String sidx,String phone,String roleId) {

		
		GridDataInfo info = new GridDataInfo();
		Map<String, Object> param = new HashMap<String, Object>();
		
		param.put("sortname", sidx);
		param.put("sortorder", sord);
		param.put("roleId", roleId);
		param.put("phone", phone);
		try {
			int count =Integer.parseInt(reportTableService.reportCount(param).toString());

			info.setRecords(count);
			info.setPage(Integer.parseInt(page));
			info.setPageRows(Integer.parseInt(rows));

			PageUtils pageUtils = new PageUtils();
			pageUtils.analyzePage(info);

			param.put("start", pageUtils.getStartNum());
			param.put("limit", pageUtils.getEndNum());

			List<Map<String, String>> list = reportTableService.queryReport(param);
			info.setRows(list);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return info;
	}

	
	
	
	@RequestMapping(value="/goReport")
	public ModelAndView goReport(){
		ModelAndView mv = this.getModelAndView();
		
		try {
			mv.setViewName("reportTable/report");
		} catch (Exception e) {
			logger.error(e.toString(), e);
		}						
		return mv;
	}	
	
	
	/**
	 * 导出EXCEL
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/exportExcel")
	public void exportExcel(String methodName, String colNames,
			String colModel, String strPars, String excelNm,
			HttpServletResponse response) {

		try {

			Map<String, Object> param = new HashMap<String, Object>();
			Map<String, Object> choiceParam = new HashMap<String, Object>();
			param.put("methodName", methodName);
			param.put("colModel", colModel);
			// undefined
			String[] arrayPar = strPars.split(",");
			for (int i = 0; i < arrayPar.length; i++) {
				String val = arrayPar[i];
				choiceParam.put(val.substring(0, val.indexOf(":")),
						val.substring(val.indexOf(":") + 1, val.length()));
			}
			MethodInvoke method = new MethodInvoke();
			//method.setClassName("com.ai.analyze.manager.report.impl.ReportManagerImpl");
			method.setMethodName(methodName);
			method.setParam(choiceParam);
			List<Map<String, Object>> list = (List<Map<String, Object>>) method
					.excuteMethod(reportTableService);
			colNames = new String(colNames.getBytes("iso-8859-1"), "UTF-8");
			excelNm = new String(excelNm.getBytes("iso-8859-1"), "UTF-8");
			ExportUtils exportUtils = new ExportUtils(colNames.split(","),
					list, excelNm, colModel.split(","));
			HSSFWorkbook hwb = exportUtils.export();
			response.setContentType("application/vnd.ms-excel");
			String fileName = new String(excelNm.getBytes("GB2312"),
					"iso-8859-1") + ".xls";
			
			response.setHeader("Content-disposition", "attachment;filename="
					+ fileName);
			OutputStream os = response.getOutputStream();
			hwb.write(os);
			os.flush();
			os.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
