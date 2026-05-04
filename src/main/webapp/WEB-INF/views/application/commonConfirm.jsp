<%@ page contentType="text/html;charset=UTF-8"%>
<div class="customer-info-body-base">
	カードに登録されているお客様情報の照会・変更をすることができます。<br>
	ご本人様情報・ご勤務先情報を変更する場合は、「変更する」ボタンを押し、変更ページにてお手続きください。<br>
	<h3>ご本人様情報</h3>
	<table class="customer">
		<tr>
			<th>氏名</th>
			<td><c:out value="${applicationUpdateSaForm.firstname}" />　<c:out value="${applicationUpdateSaForm.lastname}" /></td>
		</tr>
		<tr>
			<th>氏名（カナ）</th>
			<td><c:out value="${form.firstnameKana}" />　<c:out value="${form.lastnameKana}" /></td>
		</tr>
		<tr>
			<th>郵便番号</th>
			<td><c:out value="${form.zip1}" />-<c:out value="${form.zip2}" /></td>
		</tr>
		<tr>
			<th>住所</th>
			<td>
				<c:out value="${form.addressPrefecture}" /><br>
				<c:out value="${form.addressCity}" /><br>
				<c:out value="${form.addressOoaza}" /><br>
				<c:out value="${form.addressAza}" /><br>
				<c:out value="${form.addressOther}" />
			</td>
		</tr>
		<tr>
			<th>電話番号</th>
			<td class=""><c:out value="${form.tel1}" />-<c:out value="${form.tel2}" />-<c:out value="${form.tel3}" /></td>
		</tr>
		<tr>
			<th>携帯電話番号</th>
			<td class=""><c:out value="${form.mobileTel1}" />-<c:out value="${form.mobileTel2}" />-<c:out value="${form.mobileTel3}" /></td>
		</tr>
		<tr>
			<th>メールアドレス</th>
			<td class=""><c:out value="${form.email}" /></td>
		</tr>
		<tr>
			<th>ご家族について</th>
			<td><c:out value="${dto.dispSetaiFamily}" /></td>
		</tr>
		<tr>
			<th>世帯人数(同一生計の人数)</th>
			<td><c:out value="${form.setaiCount}" />人世帯</td>
		</tr>
		<tr>
			<th>居住状況</th>
			<td><c:out value="${dto.dispSetaiStatus}" /></td>
		</tr>
		<tr>
			<th>居住年数</th>
			<td><c:out value="${form.setaiYear}" />年</td>
		</tr>
		<tr>
			<th>住宅ローンもしくは家賃のお支払い</th>
			<td><c:out value="${dto.dispSetaiLoan}" /></td>
		</tr>
		<tr>
			<th>本人年収</th>
			<td><c:out value="${form.income}" />万円</td>
		</tr>
		<tr>
			<th>預貯金額</th>
			<td><c:out value="${form.savings}" />万円</td>
		</tr>
	</table>
</div>
<div class="customer-info-body-office">
	<h3>ご勤務先情報</h3>
	<table>
		<tr>
			<th>職業</th>
			<td><c:out value="${dto.dispEmploymentStatus}" /></td>
		</tr>
		<tr>
			<th>勤務先</th>
			<td><c:out value="${form.companyName}" /></td>
		</tr>
		<tr>
			<th>部署</th>
			<td><c:out value="${form.companyDepartment}" /></td>
		</tr>
		<tr>
			<th>郵便番号</th>
			<td><c:out value="${form.companyZip1}" />-<c:out value="${form.companyZip2}" /></td>
		</tr>
		<tr>
			<th>住所</th>
			<td>
				<c:out value="${form.companyAddressPrefecture}" /><br>
				<c:out value="${form.companyAddressCity}" /><br>
				<c:out value="${form.companyAddressOoaza}" /><br>
				<c:out value="${form.companyAddressAza}" /><br>
				<c:out value="${form.companyAddressOther}" />
			</td>
		</tr>
		<tr>
			<th>電話番号</th>
			<td><c:out value="${form.companyTel1}" />-<c:out value="${form.companyTel2}" />-<c:out value="${form.companyTel3}" /></td>
		</tr>
		<tr>
			<th>業種</th>
			<td><c:out value="${dto.dispCompanyIndustryType}" /></td>
		</tr>
		<tr>
			<th>勤続年数</th>
			<td><c:out value="${form.companyWorkYears}" />年</td>
		</tr>
	</table>

	<form:hidden path="id" />
	<form:hidden path="firstname" />
	<form:hidden path="lastname" />
	<form:hidden path="lastnameKana" />
	<form:hidden path="firstnameKana" />
	<form:hidden path="zip1" />
	<form:hidden path="zip2" />
	<form:hidden path="addressPrefecture" />
	<form:hidden path="addressCity" />
	<form:hidden path="addressOoaza" />
	<form:hidden path="addressAza" />
	<form:hidden path="addressOther" />
	<form:hidden path="tel1" />
	<form:hidden path="tel2" />
	<form:hidden path="tel3" />
	<form:hidden path="mobileTel1" />
	<form:hidden path="mobileTel2" />
	<form:hidden path="mobileTel3" />
	<form:hidden path="email" />
	<form:hidden path="setaiFamily" />
	<form:hidden path="setaiCount" />
	<form:hidden path="setaiStatus" />
	<form:hidden path="setaiYear" />
	<form:hidden path="setaiLoan" />
	<form:hidden path="income" />
	<form:hidden path="savings" />
	<form:hidden path="employmentStatus" />
	<form:hidden path="companyName" />
	<form:hidden path="companyZip1" />
	<form:hidden path="companyZip2" />
	<form:hidden path="companyAddressPrefecture" />
	<form:hidden path="companyAddressCity" />
	<form:hidden path="companyAddressOoaza" />
	<form:hidden path="companyAddressAza" />
	<form:hidden path="companyAddressOther" />
	<form:hidden path="companyTel1" />
	<form:hidden path="companyTel2" />
	<form:hidden path="companyTel3" />
	<form:hidden path="companyDepartment" />
	<form:hidden path="companyIndustryType" />
	<form:hidden path="companyWorkYears" />
	<form:hidden path="updateDate" />
</div>
