(function () {

  // 정규식
  const REGEX_ID  = /^[A-Za-z0-9]{4,12}$/;
  const REGEX_PWD = /^[A-Za-z0-9@$!%*#?&]{4,20}$/;

  // 요소
  const form       = document.getElementById('loginForm');
  const inputId    = document.getElementById('userId');
  const inputPwd   = document.getElementById('userPwd');
  const msgId      = document.getElementById('msg-userId');
  const msgPwd     = document.getElementById('msg-userPwd');
  const groupId    = document.getElementById('group-userId');
  const groupPwd   = document.getElementById('group-userPwd');
  const togglePwd  = document.getElementById('togglePwd');
  const eyeIcon    = document.getElementById('eyeIcon');

  // ── 유효성 상태 적용 헬퍼 ──────────────────────
  function setValid(group, msg, text) {
    group.classList.remove('is-invalid');
    group.classList.add('is-valid');
    msg.textContent = text || '';
  }

  function setInvalid(group, msg, text) {
    group.classList.remove('is-valid');
    group.classList.add('is-invalid');
    msg.textContent = text;
  }

  function clearState(group, msg) {
    group.classList.remove('is-valid', 'is-invalid');
    msg.textContent = '';
  }

  // ── 아이디 검증 ────────────────────────────────
  function validateId() {
    const val = inputId.value.trim();
    if (val === '') {
      clearState(groupId, msgId);
      return false;
    }
    if (!REGEX_ID.test(val)) {
      setInvalid(groupId, msgId, '영문 또는 숫자 4~12자로 입력해주세요.');
      return false;
    }
    setValid(groupId, msgId, '');
    return true;
  }

  // ── 비밀번호 검증 ───────────────────────────────
  function validatePwd() {
    const val = inputPwd.value;
    if (val === '') {
      clearState(groupPwd, msgPwd);
      return false;
    }
    if (!REGEX_PWD.test(val)) {
      setInvalid(groupPwd, msgPwd, '영문·숫자·특수문자(@$!%*#?&) 4~20자로 입력해 주세요.');
      return false;
    }
    setValid(groupPwd, msgPwd, '');
    return true;
  }

  // ── 이벤트 리스너 ───────────────────────────────
  inputId.addEventListener('blur',  validateId);
  inputId.addEventListener('input', function () {
    if (groupId.classList.contains('is-invalid')) validateId();
  });

  inputPwd.addEventListener('blur',  validatePwd);
  inputPwd.addEventListener('input', function () {
    if (groupPwd.classList.contains('is-invalid')) validatePwd();
  });

  // ── 비밀번호 보기/숨기기 ─────────────────────────
  togglePwd.addEventListener('click', function () {
    const isPassword = inputPwd.type === 'password';
    inputPwd.type = isPassword ? 'text' : 'password';
    // lucide 아이콘 교체
    eyeIcon.setAttribute('data-lucide', isPassword ? 'eye-off' : 'eye');
    lucide.createIcons();
  });

  // ── 폼 제출 최종 검증 ────────────────────────────
  form.addEventListener('submit', function (e) {
    const idOk  = validateId();
    const pwdOk = validatePwd();

    if (!idOk || !pwdOk) {
      e.preventDefault();
      // 첫 번째 오류 필드에 포커스
      if (!idOk)  { inputId.focus();  return; }
      if (!pwdOk) { inputPwd.focus(); return; }
    }
  });

})();