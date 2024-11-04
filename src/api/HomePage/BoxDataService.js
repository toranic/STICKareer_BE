class BoxDataService {
  async getBoxData() {
    try {
      // API 엔드포인트로 요청
      const response = await fetch('http://localhost:8080/api/boxes');
      const data = await response.json();
      return data;
    } catch (error) {
      console.error('박스 데이터 가져오기 실패:', error);
      return [];
    }
  }
}

export default BoxDataService; 