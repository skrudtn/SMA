package Control;

import Model.*;
import java.util.Iterator;
import java.util.ArrayList;

public class ResultManager {

	public int calculateTestCaseNum(Version ver) {
		int errorNum = 0;
		int singleNum = 0;
		int testcaseNum = 0;
		ArrayList<String> propertyCheck = new ArrayList<String>();
		ArrayList<Integer> propertyNumCheck = new ArrayList<Integer>();
		
		Version tmp = ver.cloneVersion();
		/*for(int i = 0; i < v.categoryNum; i++) {
			for(int j = 0; j < v.categoryList.get(i).RPValueNum; i++) {
				for(int k = 0; k < v.categoryList.get(i).rpValueList.get(j).constraintsNum; k++) {
					if(v.categoryList.get(i).rpValueList.get(j).constraintsList.get(k).equals("error")) {
						//v.categoryList.get(i).rpValueList.remove(j); 
						//지울시 index 변경으로 arrayindexoutofbound 예상됨.
						errorNum++;
					}
					else if(v.categoryList.get(i).rpValueList.get(j).constraintsList.get(k).equals("single")) {
						singleNum++;
					}
				}
			}
		}
		*/
		//for 돌면서 error와 ㅅsingle ㅁ찾아서 갯수만큼 ++;
		
		//if constriants 처리해야함.
		
		//iterator를 사용하면 index가 변해도 상관 없을 듯.
		
		
			Iterator<Category> cati = tmp.getCategoryList().iterator();
			while(cati.hasNext()) {
				Category cat = (Category)cati.next();
				Iterator<RepresentativeValue> rpvi = cat.getRPValueList().iterator();
				while(rpvi.hasNext()) {
					RepresentativeValue rpv = (RepresentativeValue)rpvi.next();
					Iterator<String> coni = rpv.getConstraintsList().iterator();
					while(coni.hasNext()) {
						String con = (String)coni.next();
						if(con.equals("error")) {
							errorNum++;
						}
						else if(con.equals("single")) {
							singleNum++;
						}
						else if(con.startsWith("p")) {
							propertyCheck.add(con.substring(8)); // " " + propertyName;
						}
					}
				}
			}
			/*cati = tmp.categoryList.iterator();
			while(cati.hasNext()) {
				Category cat = (Category)cati.next();
				Iterator<RepresentativeValue> rpvi = cat.rpValueList.iterator();
				while(rpvi.hasNext()) {
					RepresentativeValue rpv = (RepresentativeValue)rpvi.next();
					Iterator<String> coni = rpv.constraintsList.iterator();
					while(coni.hasNext()) {
						String con = (String)coni.next();
						if(con.equals("error")) {
							cat.rpValueList.remove(rpv); //그냥 삭제하면 원본 훼손! 클론 사용하던지 할 것.
						}
						else if(con.equals("single")) {
							cat.rpValueList.remove(rpv); //그냥 삭제하면 원본 훼손! 클론 사용하던지 할 것.
						}
					}
				}
			}*/
			for(int i = 0; i < tmp.getCategoryNum(); i++) {
				for(int j = 0; j < tmp.getCategoryList().get(i).getRPValueNum(); j++) {
					for(int k = 0; k < tmp.getCategoryList().get(i).getRPValueList().get(j).getConstraintsList().size(); k++) {
						if(tmp.getCategoryList().get(i).getRPValueList().get(j).getConstraintsList().get(k).equals("error")) { 
							//지울시 index 변경으로 arrayindexoutofbound 예상됨.
							tmp.getCategoryList().get(i).setRPValueNum(tmp.getCategoryList().get(i).getRPValueList().size()-1);
							tmp.getCategoryList().get(i).getRPValueList().get(j).setConstraintsNum(tmp.getCategoryList().get(i).getRPValueList().get(j).getConstraintsList().size()-1);
							tmp.getCategoryList().get(i).getRPValueList().remove(j);
							j--;
							break;
						}
						else if(tmp.getCategoryList().get(i).getRPValueList().get(j).getConstraintsList().get(k).equals("single")) {
							tmp.getCategoryList().get(i).setRPValueNum(tmp.getCategoryList().get(i).getRPValueList().size()-1);
							tmp.getCategoryList().get(i).getRPValueList().get(j).setConstraintsNum(tmp.getCategoryList().get(i).getRPValueList().get(j).getConstraintsList().size()-1);
							tmp.getCategoryList().get(i).getRPValueList().remove(j);
							j--;
							break;
						}
						else if(tmp.getCategoryList().get(i).getRPValueList().get(j).getConstraintsList().get(k).equals(" ")) {
							tmp.getCategoryList().get(i).setRPValueNum(tmp.getCategoryList().get(i).getRPValueList().size());
						}
					}
				}
			}
			for(int i = 0; i < propertyCheck.size(); i++) {
				for(int j = i+1; j < propertyCheck.size(); j++) {
					if(propertyCheck.get(j).equals(propertyCheck.get(i))) {
						propertyCheck.remove(j);
					}
				}
			}
			//test
			Iterator test = propertyCheck.iterator();
			while(test.hasNext()) {
				String n = (String)test.next();
				System.out.println("property " + n);
			}
			//property 들의 중복을 없애고 저장.

			Iterator<String> pci = propertyCheck.iterator();
			
			while(pci.hasNext()) {
				int tmpcatproperty = 0;
				String check = (String)pci.next();
				System.out.println(check);
				cati = tmp.getCategoryList().iterator();
				while(cati.hasNext()) {
					Category cat = (Category)cati.next();
					cat.setPropertyNum(0);
					Iterator<RepresentativeValue> rpvi = cat.getRPValueList().iterator();
					while(rpvi.hasNext()) {
						RepresentativeValue rpv = (RepresentativeValue)rpvi.next();
						Iterator<String> coni = rpv.getConstraintsList().iterator();
						while(coni.hasNext()) {
							String con = (String)coni.next();
							if(con.equals("if" + check)) {
								cat.setPropertyNum(cat.getPropertyNum()+1);
								System.out.println(cat.getPropertyNum());
							}
						}
						//cat.setPropertyNum(cat.getPropertyNum() + rpv.getPropertyNum());
					}
//					if(cat.getPropertyNum() != cat.getRPValueNum()) {
//						cat.setPropertyNum(cat.getPropertyNum()+1);
//					}
					System.out.println("propertynum = " + cat.getPropertyNum() + "rpnum = " + cat.getRPValueNum());
					if(cat.getPropertyNum() != 0) {
						int ifcount = 0;
						Iterator<RepresentativeValue> ifcrpvi = cat.getRPValueList().iterator();
						while(ifcrpvi.hasNext()) {
							RepresentativeValue ifcrpv = (RepresentativeValue)ifcrpvi.next();
							Iterator<String> ifcconi = ifcrpv.getConstraintsList().iterator();
							while(ifcconi.hasNext()) {
								String ifccon = (String)ifcconi.next();
								if(ifccon.startsWith("i")) {
									ifcount++;
									break;
								}
							}
						}
						System.out.println("rpnum = " + cat.getRPValueList().size() + "ifc = " + ifcount);
						if(cat.getRPValueList().size() != ifcount)
							tmpcatproperty = cat.getPropertyNum()+1;
						else
							tmpcatproperty = cat.getPropertyNum();	
					}
				}
				propertyNumCheck.add(tmpcatproperty);
			}
			
			//test
			Iterator test2 = propertyNumCheck.iterator();
			while(test2.hasNext()) {
				int n = (int)test2.next();
				System.out.println("property num" + n);
			}
			//Property별로 돌면서 체크 후 갯수 추가.
			//cati = tmp.getCategoryList().iterator();
			//pci = propertyCheck.iterator();
			//while(pci.hasNext()) {
			//	String check = (String)pci.next();
			//	while(cati.hasNext()) {
			//		Category cat = (Category)cati.next();
			//		Iterator<RepresentativeValue> rpvi = cat.getRPValueList().iterator();
			//		while(rpvi.hasNext()) {
			//			RepresentativeValue rpv = (RepresentativeValue)rpvi.next();
			//			Iterator<String> coni = rpv.getConstraintsList().iterator();
			//			while(coni.hasNext()) {
			//				String con = (String)coni.next();
			//				if(con.contains(check) && con.startsWith("i")) {
			//					cat.getRPValueList().remove(rpv);
			//				}
			//			}
			//		}
			//	}
			//}
			
			
			for(int i = 0; i < propertyCheck.size(); i++) {
				String check = propertyCheck.get(i);
				cati = tmp.getCategoryList().iterator();
				while(cati.hasNext()) {
					Category cat = (Category)cati.next();
					Iterator<RepresentativeValue> rpvi = cat.getRPValueList().iterator();
					while(rpvi.hasNext()) {
						RepresentativeValue rpv = (RepresentativeValue)rpvi.next();
						Iterator<String> coni = rpv.getConstraintsList().iterator();
						while(coni.hasNext()) {
							String con = (String)coni.next();
							if(con.equals("property" + check)) {
							rpv.setPropertyNum(propertyNumCheck.get(i));
							System.out.println("pn = " + i + " th " + propertyNumCheck.get(i));
							}
						}
					}
				}
			}
			
			for(int i = 0; i < tmp.getCategoryNum(); i++) {
				for(int j = 0; j < tmp.getCategoryList().get(i).getRPValueNum(); j++) {
					for(int k = 0; k < tmp.getCategoryList().get(i).getRPValueList().get(j).getConstraintsList().size(); k++) {
						if(tmp.getCategoryList().get(i).getRPValueList().get(j).getConstraintsList().get(k).startsWith("i")) { 
							tmp.getCategoryList().get(i).setRPValueNum(tmp.getCategoryList().get(i).getRPValueList().size()-1);
							tmp.getCategoryList().get(i).getRPValueList().get(j).setConstraintsNum(tmp.getCategoryList().get(i).getRPValueList().get(j).getConstraintsList().size()-1);
							tmp.getCategoryList().get(i).getRPValueList().remove(j);
							j--;
							break;
						}
					}
				}
			}
			
			cati = tmp.getCategoryList().iterator();
				while(cati.hasNext()) {
					Category cat = (Category)cati.next();
					cat.setPropertyNum(0);
					Iterator<RepresentativeValue> rpvi = cat.getRPValueList().iterator();
					while(rpvi.hasNext()) {
						RepresentativeValue rpv = (RepresentativeValue)rpvi.next();
						if(rpv.getPropertyNum() == 0) {
							rpv.setPropertyNum(1);
						}
						cat.setPropertyNum(cat.getPropertyNum() + rpv.getPropertyNum());
					}
				}
				
			//	RepresentativeValue마다의 가지수를 정의함.
			int tmpnum;
			testcaseNum = 1;
			
			cati = tmp.getCategoryList().iterator();
			while(cati.hasNext()) {
				tmpnum = 0;
				Category cat = (Category)cati.next();
				if(cat.getPropertyNum() == 0)
					cat.setPropertyNum(1);
				System.out.println(cat.getPropertyNum());
				tmpnum += cat.getPropertyNum();
				
				testcaseNum *= tmpnum;
			}
			
			testcaseNum += errorNum;
			testcaseNum += singleNum;
			
			ver.setTestcaseNum(testcaseNum);
		return testcaseNum;
	}
	
	public void combinationTestCase(Version v) {
		ArrayList<String> propertyCheck = new ArrayList<String>();
		ArrayList<RepresentativeValue> sinerrproperty = new ArrayList<RepresentativeValue>();
		ArrayList<String> result = new ArrayList<String>();
		Version tmp = v.cloneVersion();
		
		Iterator<Category> cati = tmp.getCategoryList().iterator();
		while(cati.hasNext()) {
			Category cat = (Category)cati.next();
			Iterator<RepresentativeValue> rpvi = cat.getRPValueList().iterator();
			while(rpvi.hasNext()) {
				RepresentativeValue rpv = (RepresentativeValue)rpvi.next();
				Iterator<String> coni = rpv.getConstraintsList().iterator();
				while(coni.hasNext()) {
					String con = (String)coni.next();
					if(con.equals("error")) {
						sinerrproperty.add(rpv);
					}
					else if(con.equals("single")) {
						sinerrproperty.add(rpv);
					}
					else if(con.startsWith("p")) {
						propertyCheck.add(con.substring(8)); // " " + propertyName;
					}
				}
			}
		}
		
		for(int i = 0; i < tmp.getCategoryNum(); i++) {
			for(int j = 0; j < tmp.getCategoryList().get(i).getRPValueNum(); j++) {
				for(int k = 0; k < tmp.getCategoryList().get(i).getRPValueList().get(j).getConstraintsList().size(); k++) {
					if(tmp.getCategoryList().get(i).getRPValueList().get(j).getConstraintsList().get(k).equals("error")) { 
						//지울시 index 변경으로 arrayindexoutofbound 예상됨.
						tmp.getCategoryList().get(i).setRPValueNum(tmp.getCategoryList().get(i).getRPValueList().size()-1);
						tmp.getCategoryList().get(i).getRPValueList().get(j).setConstraintsNum(tmp.getCategoryList().get(i).getRPValueList().get(j).getConstraintsList().size()-1);
						tmp.getCategoryList().get(i).getRPValueList().remove(j);
						j--;
						break;
					}
					else if(tmp.getCategoryList().get(i).getRPValueList().get(j).getConstraintsList().get(k).equals("single")) {
						tmp.getCategoryList().get(i).setRPValueNum(tmp.getCategoryList().get(i).getRPValueList().size()-1);
						tmp.getCategoryList().get(i).getRPValueList().get(j).setConstraintsNum(tmp.getCategoryList().get(i).getRPValueList().get(j).getConstraintsList().size()-1);
						tmp.getCategoryList().get(i).getRPValueList().remove(j);
						j--;
						break;
					}
					else if(tmp.getCategoryList().get(i).getRPValueList().get(j).getConstraintsList().get(k).equals(" ")) {
						tmp.getCategoryList().get(i).setRPValueNum(tmp.getCategoryList().get(i).getRPValueList().size());
					}
				}
			}
		}
		
		for(int i = 0; i < propertyCheck.size(); i++) {
			for(int j = i+1; j < propertyCheck.size(); j++) {
				if(propertyCheck.get(j).equals(propertyCheck.get(i))) {
					propertyCheck.remove(j);
				}
			}
		}
		ArrayList<Integer> conditionCheck = new ArrayList<Integer>();
		for(int i = 0; i < propertyCheck.size(); i++)
			conditionCheck.add(0);
		String tmpresult = "";
		ArrayList<Iterator<RepresentativeValue>> tmpvi = new ArrayList<Iterator<RepresentativeValue>>();
		
		for(int i = 0; i < tmp.getCategoryList().size(); i++)
			tmpvi.add(tmp.getCategoryList().get(i).getRPValueList().iterator());
		
		recurse(0, tmp.getCategoryList().size(), tmpvi, conditionCheck, propertyCheck, tmpresult, result, tmp);
		
		for(int i = 0; i < sinerrproperty.size(); i++)
			result.add(sinerrproperty.get(i).getRPValueName());
		
		Iterator<String> test = result.iterator();
		while(test.hasNext())
			v.setResult((String)test.next());
		
	}
	
	public void recurse(int it, int j, ArrayList<Iterator<RepresentativeValue>> tmpvi, ArrayList<Integer> conditionCheck, ArrayList<String> propertyCheck, String tmpresult, ArrayList<String> result, Version tmp) {
		
		if(it >= j) {
			result.add(tmpresult);
			it--;
			return;
		}
		else {
		while(tmpvi.get(it).hasNext()) {
			
			if(tmpresult.equals("")) {
				for(int i = 0; i < it; i++)
					tmpresult = tmpresult + "    ";
			}
			
			RepresentativeValue rpv = (RepresentativeValue)tmpvi.get(it).next();
			Iterator<String> coni = rpv.getConstraintsList().iterator();
			while(coni.hasNext()) {
				int added = 0;
				int id = 0;
				String con = (String)coni.next();
				if(con.startsWith("p")) {
					for(int i = 0; i < propertyCheck.size(); i++) {
						if(propertyCheck.get(i).equals(con.substring(8))) {
							if(conditionCheck.get(i).equals(0)) {
							conditionCheck.set(i, 1);
							tmpresult = tmpresult+ "/" + rpv.getRPValueName();
							added++;
							id = i;
							}
						}
					}
				}
				else if(con.startsWith("i")) {
					for(int i = 0; i < propertyCheck.size(); i++) {
						if(propertyCheck.get(i).equals(con.substring(2))) {
							if(conditionCheck.get(i).equals(1)) {
								tmpresult = tmpresult+ "/" + rpv.getRPValueName();
								added++;
								id = i;
							}
						}
					}
				}
				
				else {
					tmpresult = tmpresult+ "/" + rpv.getRPValueName();
					added++;
				}
				if(id != 0) {
				conditionCheck.set(id, 0);
				}
				if(added == 1) {
					added = 0;
					break;
				}
			}
			
			recurse(it+1, j, tmpvi, conditionCheck, propertyCheck, tmpresult, result, tmp);
			
			
			tmpresult = "";
		}
		}
		it--;
		tmpvi.set(it+1, tmp.getCategoryList().get(it+1).getRPValueList().iterator());
		
		return;
	}
}
