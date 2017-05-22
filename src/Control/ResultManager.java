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
						//����� index �������� arrayindexoutofbound �����.
						errorNum++;
					}
					else if(v.categoryList.get(i).rpValueList.get(j).constraintsList.get(k).equals("single")) {
						singleNum++;
					}
				}
			}
		}
		*/
		//for ���鼭 error�� ��single ��ã�Ƽ� ������ŭ ++;
		
		//if constriants ó���ؾ���.
		
		//iterator�� ����ϸ� index�� ���ص� ��� ���� ��.
		
		
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
							cat.rpValueList.remove(rpv); //�׳� �����ϸ� ���� �Ѽ�! Ŭ�� ����ϴ��� �� ��.
						}
						else if(con.equals("single")) {
							cat.rpValueList.remove(rpv); //�׳� �����ϸ� ���� �Ѽ�! Ŭ�� ����ϴ��� �� ��.
						}
					}
				}
			}*/
			for(int i = 0; i < tmp.getCategoryNum(); i++) {
				for(int j = 0; j < tmp.getCategoryList().get(i).getRPValueNum(); j++) {
					for(int k = 0; k < tmp.getCategoryList().get(i).getRPValueList().get(j).getConstraintsNum(); k++) {
						if(tmp.getCategoryList().get(i).getRPValueList().get(j).getConstraintsList().get(k).equals("error")) {
							tmp.getCategoryList().get(i).getRPValueList().remove(j); 
							//����� index �������� arrayindexoutofbound �����.
							tmp.getCategoryList().get(i).setRPValueNum(tmp.getCategoryList().get(i).getRPValueList().size());
							break;
						}
						else if(tmp.getCategoryList().get(i).getRPValueList().get(j).getConstraintsList().get(k).equals("single")) {
							tmp.getCategoryList().get(i).getRPValueList().remove(j);
							tmp.getCategoryList().get(i).setRPValueNum(tmp.getCategoryList().get(i).getRPValueList().size());
							break;
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
			//property ���� �ߺ��� ���ְ� ����.

			Iterator<String> pci = propertyCheck.iterator();
			cati = tmp.getCategoryList().iterator();
			while(pci.hasNext()) {
				String check = (String)pci.next();
				while(cati.hasNext()) {
					Category cat = (Category)cati.next();
					Iterator<RepresentativeValue> rpvi = cat.getRPValueList().iterator();
					while(rpvi.hasNext()) {
						RepresentativeValue rpv = (RepresentativeValue)rpvi.next();
						Iterator<String> coni = rpv.getConstraintsList().iterator();
						while(coni.hasNext()) {
							String con = (String)coni.next();
							if(con.contains(check) && con.startsWith("i")) {
								rpv.setPropertyNum(rpv.getPropertyNum()+1);
							}
						}
						if(rpv.getPropertyNum() == 0) {
							rpv.setPropertyNum(1);
						}
						cat.setPropertyNum(cat.getPropertyNum() + rpv.getPropertyNum());
					}
					propertyNumCheck.add(cat.getPropertyNum());
				}
			}
			//Property���� ���鼭 üũ �� ���� �߰�.
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
			cati = tmp.getCategoryList().iterator();
			
			for(int i = 0; i < propertyCheck.size(); i++) {
				String check = propertyCheck.get(i);
				while(cati.hasNext()) {
					Category cat = (Category)cati.next();
					Iterator<RepresentativeValue> rpvi = cat.getRPValueList().iterator();
					while(rpvi.hasNext()) {
						RepresentativeValue rpv = (RepresentativeValue)rpvi.next();
						Iterator<String> coni = rpv.getConstraintsList().iterator();
						while(coni.hasNext()) {
							String con = (String)coni.next();
							if(con.contains(check)) {
							rpv.setPropertyNum(propertyNumCheck.get(i));
							}
						}
						if(rpv.getPropertyNum() == 0) {
							rpv.setPropertyNum(1);
						}
					}
				}
			}
			
			for(int i = 0; i < tmp.getCategoryNum(); i++) {
				for(int j = 0; j < tmp.getCategoryList().get(i).getRPValueNum(); j++) {
					for(int k = 0; k < tmp.getCategoryList().get(i).getRPValueList().get(j).getConstraintsNum(); k++) {
						System.out.println("kkk"+k);
						if(tmp.getCategoryList().get(i).getRPValueList().get(j).getConstraintsList().get(k).startsWith("i")) {
							tmp.getCategoryList().get(i).getRPValueList().remove(j); 
							tmp.getCategoryList().get(i).setRPValueNum(tmp.getCategoryList().get(i).getRPValueList().size());
							break;
						}
					}
				}
			}
			//	RepresentativeValue������ �������� ������.
			int tmpnum;
			testcaseNum = 1;
			
			cati = tmp.getCategoryList().iterator();
			while(cati.hasNext()) {
				tmpnum = 0;
				Category cat = (Category)cati.next();
				Iterator<RepresentativeValue> rpvi = cat.getRPValueList().iterator();
				while(rpvi.hasNext()) {
					RepresentativeValue rpv = (RepresentativeValue)rpvi.next();
					tmpnum += rpv.getPropertyNum();
				}
				
				testcaseNum *= tmpnum;
			}
			
			testcaseNum += errorNum;
			testcaseNum += singleNum;
			
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
				for(int k = 0; k < tmp.getCategoryList().get(i).getRPValueList().get(j).getConstraintsNum(); k++) {
					if(tmp.getCategoryList().get(i).getRPValueList().get(j).getConstraintsList().get(k).equals("error")) {
						tmp.getCategoryList().get(i).getRPValueList().remove(j); 
						tmp.getCategoryList().get(i).setRPValueNum(tmp.getCategoryList().get(i).getRPValueList().size());
						break;
					}
					else if(tmp.getCategoryList().get(i).getRPValueList().get(j).getConstraintsList().get(k).equals("single")) {
						tmp.getCategoryList().get(i).getRPValueList().remove(j);
						tmp.getCategoryList().get(i).setRPValueNum(tmp.getCategoryList().get(i).getRPValueList().size());
						break;
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
		
		recurse(0, tmp.getCategoryList().size(), tmpvi, conditionCheck, propertyCheck, tmpresult, result);
		
		for(int i = 0; i < sinerrproperty.size(); i++)
			result.add(sinerrproperty.get(i).getRPValueName());
		
		Iterator<String> test = result.iterator();
		while(test.hasNext())
			System.out.println((String)test.next());
		
	}
	
	public void recurse(int it, int j, ArrayList<Iterator<RepresentativeValue>> tmpvi, ArrayList<Integer> conditionCheck, ArrayList<String> propertyCheck, String tmpresult, ArrayList<String> result) {
		if(it >= j)
			return;
		else {
		while(tmpvi.get(it).hasNext()) {
			
			RepresentativeValue rpv = (RepresentativeValue)tmpvi.get(it).next();
			Iterator<String> coni = rpv.getConstraintsList().iterator();
			while(coni.hasNext()) {
				String con = (String)coni.next();
				if(con.startsWith("p")) {
					for(int i = 0; i < propertyCheck.size(); i++) {
						if(propertyCheck.get(i).equals(con.substring(8))) {
							conditionCheck.set(i, 1);
							tmpresult = tmpresult+ "/" + rpv.getRPValueName();
						}
					}
				}
				else if(con.startsWith("i")) {
					for(int i = 0; i < propertyCheck.size(); i++) {
						if(propertyCheck.get(i).equals(con.substring(2))) {
							if(conditionCheck.get(i).equals(1)) {
								tmpresult = tmpresult+ "/" + rpv.getRPValueName();
							}
						}
					}
				}
				
				else {
					tmpresult = tmpresult+ "/" + rpv.getRPValueName();
				}
				
			}
			
			recurse(it+1, j, tmpvi, conditionCheck, propertyCheck, tmpresult, result);
			
			result.add(tmpresult);
			tmpresult = "";
		}
		}
	}
}
