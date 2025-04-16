/**
 * 4-Score Wireframe Converter
 * 
 * This tool helps convert traditional wireframe text descriptions
 * to the Code Descriptor format for more precise AI interactions.
 */

// Sample wireframe text (replace with actual content from your wireframes)
const sampleWireframeText = `
- Headline:
  - Text: "Achieve Your Peak Fitness with the F.O.U.R. Score System"
  - Font: Mandrel Ext Extra-bold
  - Size: 36 dp
  - Color: #DAE1E9 (Dirty/Worn White)
  - Alignment: Center
  - Margin: 24 dp below the image

- Button:
  - Text: "Get Started"
  - Font: Poppins, SemiBold
  - Size: 16 dp
  - Color: #FFFFFF (White)
  - Background: #520606 (Deep Red)
  - Padding: 12 dp vertical, 24 dp horizontal
  - Alignment: Center
  - Margin: 16 dp from the top
  - Action: Navigates to the Sign-Up/Register View
`;

/**
 * Converts traditional wireframe descriptions to Code Descriptor format
 * @param {string} wireframeText - The text from wireframe documents
 * @returns {string} - XML-like Code Descriptor format
 */
function convertToCodeDescriptors(wireframeText) {
  // Split by sections (usually denoted by a dash and a component type)
  const sections = wireframeText.trim().split(/\n\s*-\s+(?=[A-Za-z]+:)/);
  
  let result = '';
  
  for (const section of sections) {
    if (!section.trim()) continue;
    
    // Extract component type
    const typeMatch = section.match(/^([A-Za-z]+):/);
    if (!typeMatch) continue;
    
    const componentType = typeMatch[1];
    
    // Process different properties
    const textMatch = section.match(/Text:\s+"([^"]+)"/);
    const fontMatch = section.match(/Font:\s+([^,\n]+)(?:,\s+([^,\n]+))?/);
    const sizeMatch = section.match(/Size:\s+(\d+)\s*dp/);
    const colorMatch = section.match(/Color:\s+(#[A-Fa-f0-9]+)/);
    const backgroundMatch = section.match(/Background:\s+(#[A-Fa-f0-9]+)/);
    const alignmentMatch = section.match(/Alignment:\s+([^,\n]+)/);
    const marginMatch = section.match(/Margin:\s+(.+?)(?:\n|$)/);
    const paddingMatch = section.match(/Padding:\s+(.+?)(?:\n|$)/);
    const actionMatch = section.match(/Action:\s+(.+?)(?:\n|$)/);
    
    // Start building the component tag
    result += `<Component\n  type="${componentType}"`;
    
    // Add attributes based on matches
    if (textMatch) {
      result += `\n  text="${textMatch[1]}"`;
    }
    
    if (fontMatch) {
      const fontFamily = fontMatch[1].trim();
      result += `\n  font="${fontFamily}"`;
      
      if (fontMatch[2]) {
        const fontWeight = fontMatch[2].trim();
        result += `\n  weight="${fontWeight}"`;
      }
    }
    
    if (sizeMatch) {
      result += `\n  size="${sizeMatch[1]}"`;
    }
    
    if (colorMatch) {
      result += `\n  color="${colorMatch[1]}"`;
    }
    
    if (backgroundMatch) {
      result += `\n  background="${backgroundMatch[1]}"`;
    }
    
    if (alignmentMatch) {
      result += `\n  align="${alignmentMatch[1].toLowerCase()}"`;
    }
    
    // Process margin
    if (marginMatch) {
      const marginText = marginMatch[1];
      let marginValue = processSpacing(marginText);
      result += `\n  margin="${marginValue}"`;
    }
    
    // Process padding
    if (paddingMatch) {
      const paddingText = paddingMatch[1];
      let paddingValue = processSpacing(paddingText);
      result += `\n  padding="${paddingValue}"`;
    }
    
    // Process action
    if (actionMatch) {
      const actionText = actionMatch[1];
      if (actionText.includes("Navigates to")) {
        const targetMatch = actionText.match(/Navigates to the ([^/]+)/);
        if (targetMatch) {
          const target = targetMatch[1].replace(/\s+View$/, '').replace(/\s+/g, '') + 'View';
          result += `\n  onPress="<Action type='Navigation' target='${target}' />"`;
        }
      }
    }
    
    // Add testID for interactive components
    if (['Button', 'Input', 'Checkbox', 'Toggle', 'RadioButton'].includes(componentType)) {
      const testIdBase = textMatch ? textMatch[1].toLowerCase().replace(/\s+/g, '') : componentType.toLowerCase();
      result += `\n  testID="${testIdBase}"`;
    }
    
    // Close the component tag
    result += `\n/>\n\n`;
  }
  
  return result.trim();
}

/**
 * Process spacing descriptions into standardized format
 * @param {string} spacingText - Text description of spacing
 * @returns {string} - Standardized spacing value
 */
function processSpacing(spacingText) {
  // Initialize default spacing (top right bottom left)
  let top = 0, right = 0, bottom = 0, left = 0;
  
  // Check for directional indicators
  if (spacingText.includes('top')) {
    const match = spacingText.match(/(\d+)\s*dp[\s\w]*top/i);
    if (match) top = match[1];
  }
  
  if (spacingText.includes('right')) {
    const match = spacingText.match(/(\d+)\s*dp[\s\w]*right/i);
    if (match) right = match[1];
  }
  
  if (spacingText.includes('bottom') || spacingText.includes('below')) {
    const match = spacingText.match(/(\d+)\s*dp[\s\w]*(bottom|below)/i);
    if (match) bottom = match[1];
  }
  
  if (spacingText.includes('left')) {
    const match = spacingText.match(/(\d+)\s*dp[\s\w]*left/i);
    if (match) left = match[1];
  }
  
  // Check for horizontal/vertical indicators
  if (spacingText.includes('horizontal')) {
    const match = spacingText.match(/(\d+)\s*dp[\s\w]*horizontal/i);
    if (match) {
      right = match[1];
      left = match[1];
    }
  }
  
  if (spacingText.includes('vertical')) {
    const match = spacingText.match(/(\d+)\s*dp[\s\w]*vertical/i);
    if (match) {
      top = match[1];
      bottom = match[1];
    }
  }
  
  // Single value for all sides
  if (!spacingText.match(/(top|right|bottom|left|below|horizontal|vertical)/i)) {
    const match = spacingText.match(/(\d+)\s*dp/i);
    if (match) {
      top = match[1];
      right = match[1];
      bottom = match[1];
      left = match[1];
    }
  }
  
  return `${top} ${right} ${bottom} ${left}`;
}

// Convert the sample wireframe
const codeDescriptorOutput = convertToCodeDescriptors(sampleWireframeText);
console.log("=== CONVERTED CODE DESCRIPTOR FORMAT ===");
console.log(codeDescriptorOutput);

// Usage examples
console.log("\n=== USAGE EXAMPLES ===");
console.log("\nExample 1: Convert a simple button");
const buttonExample = `
- Button:
  - Text: "Create Account"
  - Font: Poppins, Bold
  - Size: 18 dp
  - Color: #FFFFFF
  - Background: #520606
  - Padding: 12 dp vertical, 24 dp horizontal
  - Action: Navigates to the Dashboard View
`;
console.log(convertToCodeDescriptors(buttonExample));

console.log("\nExample 2: Convert an input field");
const inputExample = `
- Input:
  - Placeholder: "Email Address"
  - Font: Poppins, Regular
  - Size: 16 dp
  - Color: #DAE1E9
  - Border: 1 dp, #333333
  - Padding: 12 dp all sides
`;
console.log(convertToCodeDescriptors(inputExample));

// BONUS: Layout conversion example
function convertLayoutToCodeDescriptors(layoutText) {
  // This is a simplified version - a full implementation would need more robust parsing
  const typeMatch = layoutText.match(/Layout:\s+([^,\n]+)/);
  const spacingMatch = layoutText.match(/Spacing:\s+(\d+)\s*dp/);
  const paddingMatch = layoutText.match(/Padding:\s+(.+?)(?:\n|$)/);
  
  let result = '<Layout';
  
  if (typeMatch) {
    const layoutType = typeMatch[1].includes('Vertical') ? 'List' : 
                     typeMatch[1].includes('Horizontal') ? 'Row' : 'Container';
    result += ` type="${layoutType}"`;
    
    if (layoutType === 'List') {
      result += ` direction="vertical"`;
    }
  }
  
  if (spacingMatch) {
    result += ` spacing="${spacingMatch[1]}"`;
  }
  
  if (paddingMatch) {
    const paddingText = paddingMatch[1];
    let paddingValue = processSpacing(paddingText);
    result += ` padding="${paddingValue}"`;
  }
  
  result += '>\n  <!-- Child components here -->\n</Layout>';
  return result;
}

console.log("\nExample 3: Convert a layout");
const layoutExample = `
- Layout: Vertical list
  - Spacing: 16 dp
  - Padding: 20 dp all sides
`;
console.log(convertLayoutToCodeDescriptors(layoutExample));
