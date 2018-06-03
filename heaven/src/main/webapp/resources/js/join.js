/**
 * 신청서, 참여 javascript
 * 
 * @author 조민경
 */


// 스마트 에디터


// 지도 타입 설정하는 곳 ( 아무것도 설정 하지 않으면 자동으로 Normal로 적용된다 ) 초기화할 때 설정할수 있다.
var map = new naver.maps.Map('map');
// 위성지도를 사용하려면 MapTypeId 객체의 SATELLITE 상수 값을 사용합니다.
// var map = new naver.maps.Map('map', {mapTypeId:
// naver.maps.MapTypeId.SATELLITE});
// 위성지도에 지명을 적용하려면 MapTypeId 객체의 HYBRID 상수 값을 사용합니다.
// var map = new naver.maps.Map('map', {mapTypeId:
// naver.maps.MapTypeId.HYBRID});
// 기본지도에 높낮이만 적용하려면 MapTypeId 객체의 TERRAIN 상수 값을 사용합니다.
// var map = new naver.maps.Map('map', {mapTypeId:
// naver.maps.MapTypeId.TERRAIN});

// 재능기부장소 주소정보
var myaddress = '${donationVO.jpPlace}';// 도로명 주소나 지번 주소만 가능 (건물명 불가!!!!)
// 주소가 있는지 체크
naver.maps.Service
		.geocode(
				{
					address : myaddress
				},
				function(status, response) {
					if (status !== naver.maps.Service.Status.OK) {
						return alert(myaddress + '의 검색 결과가 없거나 기타 네트워크 에러');
					}
					var result = response.result;
					// 검색 결과 갯수: result.total
					// 첫번째 결과 결과 주소: result.items[0].address
					// 첫번째 검색 결과 좌표: result.items[0].point.y,
					// result.items[0].point.x
					var myaddr = new naver.maps.Point(
							result.items[0].point.x,
							result.items[0].point.y);
					map.setCenter(myaddr); // 검색된 좌표로 지도 이동
					// 마커 표시 ( 검색한 주소에 마커를 찍어둠 )
					var marker = new naver.maps.Marker({
						position : myaddr,
						map : map
					});
					// 마커 클릭 이벤트 처리 ( 클릭할 경우 infowindow에 등록된 이미지와 이름이 뜸 )
					naver.maps.Event.addListener(marker, "click", function(
							e) {
						if (infowindow.getMap()) {
							infowindow.close();
						} else {
							infowindow.open(map, marker);
						}
					});
					// 마크 클릭시 인포윈도우 오픈
					var infowindow = new naver.maps.InfoWindow(
							{
								// 띄워줄 이름과 사이트 이미지, 클릭했을경우 이동할 url 주소를 입력해주면 된다.
								content : '<h4> [제목을 넣어주세요]</h4><a href="https://developers.naver.com" target="_blank"><img src="https://developers.naver.com/inc/devcenter/images/nd_img.png"></a>'
							});
				});
